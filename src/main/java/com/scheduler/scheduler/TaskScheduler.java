package com.scheduler.scheduler;

import com.scheduler.model.Task;
import com.scheduler.queue.DeadLetterQueue;
import com.scheduler.queue.TaskPriorityQueue;
import com.scheduler.retry.RetryPolicy;

// TaskScheduler.java: orchestrates execution, retry and dispatch to DLQ
public class TaskScheduler {
     private final TaskPriorityQueue taskQueue = new TaskPriorityQueue();
     private final DeadLetterQueue dlq = new DeadLetterQueue();
     private final RetryPolicy retryPolicy = new RetryPolicy();

     public void submit(Task task) {
          taskQueue.add(task);
     }

     public void process() {
          Task task = taskQueue.poll();

          if (task == null) {
               System.out.println("No task ready at this time.");
               return;
          }

          boolean success = execute(task);

          if (!success) {
               if (retryPolicy.shouldRetry(task)) {
                    retryPolicy.applyRetry(task);
                    taskQueue.add(task);
               } else {
                    dlq.add(task);
               }
          }
     }

     private boolean execute(Task task) {
          System.out.println("⚙️ Executing: " + task);
          return Math.random() > 0.5; // 50% chance to fail
     }

     public boolean hasTasks() {
          return !taskQueue.isEmpty();
     }

     public void printDLQ() {
          dlq.print();
     }
}

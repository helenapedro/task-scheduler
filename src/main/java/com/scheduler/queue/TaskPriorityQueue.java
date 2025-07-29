package com.scheduler.queue;

import java.time.Instant;
import java.util.PriorityQueue;

import com.scheduler.model.Task;

public class TaskPriorityQueue {
     private final PriorityQueue<Task> queue = new PriorityQueue<>();

     // Add a task to the queue
     public void add(Task task) {
          queue.offer(task);
     }

     // Retrieve the next task only if it is ready to run (nextRetryAt <= now)
     public Task poll() {
          Task next = queue.peek();

          if (next != null && next.getNextRetryAt().isBefore(Instant.now())) {
               return queue.poll();
          }
          return null;
     }

     public boolean isEmpty() {
          return queue.isEmpty();
     }

     public int size() {
          return queue.size();
     }

     // for tests/debug
     public void printQueue() {
          for (Task task : queue) {
               System.out.println(task);
          }
     }
}

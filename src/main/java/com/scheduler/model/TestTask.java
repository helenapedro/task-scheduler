package com.scheduler.model;

import java.util.Arrays;
import java.util.List;

public class TestTask {
     public static void main(String[] args) throws InterruptedException {
          Task task1 = new Task(1, "Process Payment");
          Thread.sleep(100); // simulates the delay

          Task task2 = new Task(0, "Send notification");
          Thread.sleep(100);

          Task task3 = new Task(2, "Update stock");

          List<Task> tasks = Arrays.asList(task1, task2, task3);
          tasks.sort(Task::compareTo);

          System.out.println("Tasks ordered by nextRetryAt and priority:");
          for (Task task : tasks) {
               System.out.println(task);
               System.out.println("-> ID: " + task.getId());
               System.out.println("→ Priority: " + task.getPriority());
               System.out.println("→ Payload: " + task.getPayload());
               System.out.println("→ Retry: " + task.getRetryCount());
               System.out.println("→ RetryAt: " + task.getNextRetryAt());
               System.out.println("------");
          }
     }
}

package com.scheduler.queue;

import java.util.ArrayList;
import java.util.List;

import com.scheduler.model.Task;

// DeadLetterQueue.java: stores tasks that have exceeded the retries limit
public class DeadLetterQueue {
     private final List<Task> deadLetters = new ArrayList<>();

     public void add(Task task) {
          deadLetters.add(task);
          System.out.println("Moved to Dead Letter Queue: " + task);
     }

     public List<Task> getAll() {
          return deadLetters;
     }

     public void print() {
          System.out.println("📦 DLQ contains:");
          for (Task task : deadLetters) {
               System.out.println("❌ " + task);
          }
     }
}

/*
 * Dead Letter Queue (DLQ) Stores tasks that have failed too many times —
 * prevents infinite loops
 */

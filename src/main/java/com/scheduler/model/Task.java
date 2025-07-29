package com.scheduler.model;

import java.time.Instant;
import java.util.UUID;

public class Task implements Comparable<Task> {
     private final String id;
     private final int priority; // 0 = alta, 1 = média, 2 = baixa
     private final String payload;
     private int retryCount;
     private Instant nextRetryAt;

     public Task(int priority, String payload) {
          this.id = UUID.randomUUID().toString();
          this.priority = priority;
          this.payload = payload;
          this.retryCount = 0;
          this.nextRetryAt = Instant.now();
     }

     @Override
     public int compareTo(Task other) {
          int timeCompare = this.nextRetryAt.compareTo(other.nextRetryAt);
          if (timeCompare != 0)
               return timeCompare;
          return Integer.compare(this.priority, other.priority);
     }

     @Override
     public String toString() {
          return "[Task " + id + ", priority=" + priority + ", retry=" + retryCount + "]";
     }
}

package com.scheduler.model;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task implements Comparable<Task> {
     private final String id;
     private final int priority; // 0 = high, 1 = medium, 2 = low
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

     /*
      * The compareTo method first compares nextRetryAt,
      * in case of a tie, it compares priority (lowest = highest)
      */

     @Override
     public int compareTo(Task other) {
          int timeCompare = this.nextRetryAt.compareTo(other.nextRetryAt);

          return (timeCompare != 0) ? timeCompare : Integer.compare(this.priority, other.priority);
     }

     @Override
     public String toString() {
          return "[Task " + id + ", priority=" + priority + ", retry=" + retryCount + "]";
     }
}

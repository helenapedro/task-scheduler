package com.scheduler.retry;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.scheduler.model.Task;

/*RetryPolicy: defines retry logic with exponential backoff */
public class RetryPolicy {
     private static final int MAX_RETRIES = 3;

     public boolean shouldRetry(Task task) {
          return task.getRetryCount() < MAX_RETRIES;
     }

     public void applyRetry(Task task) {
          task.setRetryCount(task.getRetryCount() + 1);
          long delaySeconds = (long) Math.pow(2, task.getRetryCount()); // backoff exponencial
          task.setNextRetryAt(Instant.now().plus(delaySeconds, ChronoUnit.SECONDS));
          System.out.println("Scheduled retry #" + task.getRetryCount() + " for task " + task.getId());
     }
}

/*
 * Important concepts
 * Retry Attempt to reprocess a task after failure
 * Backoff Increasing delay between attempts (e.g., 2s, 4s, 8s, etc.)
 */

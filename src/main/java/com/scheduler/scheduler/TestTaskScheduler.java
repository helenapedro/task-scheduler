package com.scheduler.scheduler;

import com.scheduler.model.Task;

public class TestTaskScheduler {
     public static void main(String[] args) throws InterruptedException {
          TaskScheduler scheduler = new TaskScheduler();

          scheduler.submit(new Task(1, "Send email"));
          scheduler.submit(new Task(0, "Process payment"));
          scheduler.submit(new Task(2, "Update stock"));

          while (scheduler.hasTasks()) {
               scheduler.process();
               Thread.sleep(100);
          }

          scheduler.printDLQ();
     }
}

package com.scheduler;

import com.scheduler.model.Task;
import com.scheduler.scheduler.TaskScheduler;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskScheduler scheduler = new TaskScheduler();

        // add tasks
        scheduler.submit(new Task(1, "Medium Task 1"));
        scheduler.submit(new Task(0, "High Task 1"));
        scheduler.submit(new Task(2, "Low Task 1"));

        while (true) {
            scheduler.process();
            Thread.sleep(1000);
        }
    }
}

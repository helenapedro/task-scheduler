package com.scheduler.queue;

import com.scheduler.model.Task;

public class TestTaskPriorityQueue {
     public static void main(String[] args) throws InterruptedException {
          TaskPriorityQueue taskQueue = new TaskPriorityQueue();

          Task t1 = new Task(1, "Medium"); // priority 1
          Thread.sleep(50);
          Task t2 = new Task(0, "High"); // priority 0
          Thread.sleep(50);
          Task t3 = new Task(2, "Low"); // priority 2

          taskQueue.add(t1);
          taskQueue.add(t2);
          taskQueue.add(t3);

          System.out.println("Queue size: " + taskQueue.size());
          System.out.println("Tasks in order in the queue (without removing):");
          taskQueue.printQueue();

          System.out.println("\nProcessing tasks:");
          while (!taskQueue.isEmpty()) {
               Task next = taskQueue.poll();

               if (next != null) {
                    System.out.println("Executing: " + next);
               } else {
                    System.out.println("No tasks ready yet. Waiting...");
                    Thread.sleep(200); // // wait until the task is ready
               }
          }
          System.out.println("Empty queue? " + taskQueue.isEmpty());
     }

     /*
      * Mas por que a tarefa de prioridade 1 foi executada antes da 0?
      * Executing: [Task b4ab4e1c..., priority=1, retry=0]
      * Executing: [Task a050eb5..., priority=0, retry=0]
      * 
      * Isso ocorreu porque o critério principal de ordenação é o nextRetryAt,
      * e as tarefas foram criadas com Thread.sleep() entre elas. Ou seja, o Task
      * com prioridade 1 foi criado antes e tinha um nextRetryAt menor, então foi
      * executado primeiro — conforme o esperado.
      * 
      * 
      */
}

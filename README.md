# 🧠 Task Scheduler with Retry and Priority Queue (Java)

This project is a task scheduler that supports:
- execution priority
- retry with exponential backoff
- Dead Letter Queue (DLQ) for failed tasks

It is ideal for practicing **data structures**, **resilient systems**, **queue design**, and **retry logic** in Java.

---

## ✨ Features

- [x] Enqueue tasks with priority
- [x] Simulate task execution with random failures
- [x] Retry with increasing delay (exponential backoff)
- [x] Dead Letter Queue for auditing failed tasks
- [x] Modular structure (`model`, `queue`, `scheduler`, `retry`)

---

## 🏗️ Architecture

```
Client → TaskScheduler → PriorityQueue
                          ↓
                        Worker → RetryPolicy → DLQ
```

---

## 📁 Project Structure

```
src/
 └── main/
     └── java/com.scheduler/
         ├── model/Task.java
         ├── queue/TaskPriorityQueue.java, DeadLetterQueue.java
         ├── retry/RetryPolicy.java
         ├── scheduler/TaskScheduler.java
         └── scheduler/TestTaskScheduler.java
```

---

## ⚙️ How to Run

### 1. Requirements
- Java 17+
- Maven

### 2. Clone the project

```bash
git clone https://github.com/helenapedro/task-scheduler.git
cd task-scheduler
```

### 3. Compile and run

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.scheduler.Main"
```

---

## 📌 Future Improvements

- [ ] Persistence with MongoDB, SQLite or Hostinger SQL
- [ ] Monitoring dashboard (Spring Boot + REST API)
- [ ] Parallel execution with ExecutorService (multithreading)
- [ ] DLQ export to JSON or CSV
- [ ] Integration with messaging systems (RabbitMQ, Kafka)

---

## 🧠 Author

**Helena Pedro**  
MSc Candidate in Computer Science  
Software Engineer focused on architecture, microservices, and resilient systems.

---

## 📜 License

MIT

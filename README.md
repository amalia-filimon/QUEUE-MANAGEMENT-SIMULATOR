# Queue Management Simulator (Java, Multithreading & Swing)

This project simulates a real-time queue management system in Java. Multiple clients are generated with random arrival and service times and are dynamically assigned to the queue with the shortest waiting time. Each queue is managed using separate threads. The simulation is controlled via a graphical interface built with Java Swing.

---

## 🧠 Features

- Configurable simulation parameters:
  - Number of clients
  - Number of queues
  - Simulation duration
  - Arrival time interval (min/max)
  - Service time interval (min/max)
- Clients are automatically assigned to the optimal queue
- Each queue runs in its own thread using synchronization mechanisms
- Real-time simulation updates via GUI
- Event logging to `logOfEvents.txt`

---

## 🖥️ User Interface

The GUI allows users to:
- Enter simulation parameters
- Start the simulation with a button click
- View live queue status and simulation progress

The interface is implemented using Java Swing and handles input validation and error messages.

---

## 🧩 Architecture Overview

### 🧪 Model
- `Client`: represents a customer with an ID, arrival time, and service time
- `Queue`: represents a thread-managed queue using `BlockingQueue<Client>`

### ⚙️ BusinessLogic
- `Simulation`: runs the simulation using multithreading and random generation
- `Controller`: manages communication between UI and simulation logic

### 🎨 GUI
- `SimulationFrame`: graphical interface with all interactive components

---

## 🔧 Technologies Used

- Java
- Java Swing (GUI)
- Multithreading with `Runnable` and `BlockingQueue`
- Object-Oriented Programming
- Synchronization mechanisms

---

## 📁 Output

- Simulation log:  
  All events are saved to `logOfEvents.txt`, including:
  - Client arrivals
  - Client assignments
  - Queue status
  - Simulation start and end time

---


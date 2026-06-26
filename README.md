# 🚗 RouteIQ Pro

## 📖 Overview

RouteIQ Pro is a graph-based smart route optimization system that finds the shortest path between cities using **Dijkstra’s Algorithm**.
It integrates **Java, Spring Boot, MySQL, and a modern frontend UI** to simulate a real-world navigation system.

---

## ✨ Features

* 🔍 Find shortest route between cities
* 📍 Graph-based path optimization
* ⚡ Dijkstra’s Algorithm implementation
* 🗺️ Real-time route display (Frontend UI)
* 🕒 Execution time analysis
* 📜 Recent search history
* 🌐 REST API backend using Spring Boot
* 🗄️ MySQL database integration
* 🎨 Modern responsive UI

---

## 🧠 Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* REST APIs

### Database

* MySQL

### Frontend

* HTML
* CSS
* JavaScript

---

## 🧮 Algorithm Used

### Dijkstra’s Algorithm

Used to compute the shortest path in a weighted graph.

Time Complexity:
O((V + E) log V)

Where:

* V = number of cities (nodes)
* E = number of roads (edges)

---

## 📡 API Endpoints

| Method | Endpoint | Description       |
| ------ | -------- | ----------------- |
| GET    | /route   | Get shortest path |
| GET    | /cities  | Fetch all cities  |
| POST   | /city    | Add new city      |
| POST   | /road    | Add new road      |


---

## 🚀 How to Run the Project

### Backend (Spring Boot)

```bash
mvn spring-boot:run
```

Runs on:

```
http://localhost:8080
```

---

### Frontend

Open:

```
index.html
```

---

## 🎯 Future Improvements

* 🌍 Map integration (Google Maps)
* 🚦 Traffic-aware routing
* 🔄 Multiple route suggestions
* 📊 Route analytics dashboard
* 📱 Mobile app version

---

## 🏁 Conclusion

RouteIQ Pro demonstrates strong understanding of:

* Data Structures & Algorithms
* Backend Development
* Database Design
* Full-stack integration

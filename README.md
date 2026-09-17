# 🚀 RouteIQ Pro - Smart Route Optimization System

RouteIQ Pro is a full-stack web application that finds the shortest path between cities using **Dijkstra's Algorithm**. It provides an interactive interface where users can select source and destination cities and instantly receive the optimal route, total distance, and execution time.

---

## 🌟 Features

* 🔍 Find the shortest route between two cities
* ⚡ Dijkstra's Algorithm implementation for efficient path finding
* 🗺️ Dynamic road network stored in MySQL database
* 📊 Displays:

  * Shortest path
  * Total distance
  * Execution time
* 🌙 Modern responsive UI with Dark/Light mode
* ☁️ Backend deployed on Render
* 🗄️ Railway MySQL Database integration

---

## 🛠️ Tech Stack

### Frontend

* HTML5
* CSS3
* JavaScript
* Font Awesome

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### Database

* MySQL (Railway)

### Deployment

* Render
* Railway

---

## 📂 Project Structure

```
routefinder/
│
├── src/main/java/
│   ├── controller/
│   ├── graph/
│   ├── model/
│   ├── repository/
│   ├── service/
│   └── RoutefinderApplication.java
│
├── src/main/resources/
│   ├── static/
│   │   ├── index.html
│   │   ├── style.css
│   │   └── script.js
│   └── application.properties
│
└── pom.xml
```

---

## ⚙️ Algorithm Used

The project uses **Dijkstra's Algorithm**, a greedy graph algorithm that computes the shortest path from a source node to every other node in a weighted graph.

### Time Complexity

* **Using Priority Queue:** `O((V + E) log V)`

Where:

* `V` = Number of cities
* `E` = Number of roads

---

## 📡 REST API

### Find Shortest Route

```
GET /route
```

### Example

```
/route?source=Delhi&destination=Mumbai
```

### Sample Response

```json
{
    "distance": 1450,
    "path": [
        "Delhi",
        "Jaipur",
        "Ahmedabad",
        "Mumbai"
    ],
    "executionTime": 3
}
```

---

## 🚀 Running Locally

### Clone the repository

```bash
git clone https://github.com/Sipra-NITR/routefinder.git
```

### Navigate to the project

```bash
cd routefinder
```

### Run the application

Open:

"http://localhost:8080";
---
## 📸 Screenshots
### Home Page
<img width="1339" height="606" alt="image" src="https://github.com/user-attachments/assets/ce942058-1697-4821-ab01-659b9c00f86e" />

### Route Result
<img width="1267" height="575" alt="image" src="https://github.com/user-attachments/assets/46f3dcf4-8254-4cb7-a00f-411fb7f9a0f8" />

### Map Visualization
<img width="850" height="425" alt="image" src="https://github.com/user-attachments/assets/09cdc45e-d604-473c-b98c-452aff05d08f" />


## 🎯 Future Enhancements

* Multiple routing algorithms (A*, Bellman-Ford)
* Google Maps integration
* Interactive map visualization
* Traffic-aware routing
* User authentication
* Save favorite routes
* Admin dashboard for road management

---

## 👩‍💻 Author

**Sipra Sworupa Mishra**

GitHub: https://github.com/Sipra-NITR

---

## 📄 License

This project is open source and available under the MIT License.


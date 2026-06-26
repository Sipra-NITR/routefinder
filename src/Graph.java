package Project;

import java.util.*;

public class Graph {

    private Map<String, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addCity(String city) {
        adjacencyList.putIfAbsent(city, new ArrayList<>());
    }

    public void addRoad(String source, String destination, int distance) {

        addCity(source);
        addCity(destination);

        adjacencyList.get(source)
                .add(new Edge(destination, distance));

        adjacencyList.get(destination)
                .add(new Edge(source, distance));
    }

    public Map<String, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }
}

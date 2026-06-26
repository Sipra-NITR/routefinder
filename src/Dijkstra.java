package Project;

import java.util.*;

public class Dijkstra {

    static class Node {
        String city;
        int distance;

        Node(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }

    public static void findShortestPath(
            Graph graph,
            String source,
            String destination) {

        Map<String, List<Edge>> adj =
                graph.getAdjacencyList();

        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (String city : adj.keySet()) {
            dist.put(city, Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq =
                new PriorityQueue<>(
                        Comparator.comparingInt(n -> n.distance));

        dist.put(source, 0);
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            for (Edge edge : adj.get(current.city)) {

                int newDistance =
                        dist.get(current.city)
                                + edge.getDistance();

                if (newDistance <
                        dist.get(edge.getDestination())) {

                    dist.put(edge.getDestination(),
                            newDistance);

                    parent.put(edge.getDestination(),
                            current.city);

                    pq.offer(
                            new Node(
                                    edge.getDestination(),
                                    newDistance));
                }
            }
        }

        if (!dist.containsKey(destination)
                || dist.get(destination)
                == Integer.MAX_VALUE) {

            System.out.println("No path found.");
            return;
        }

        List<String> path = new ArrayList<>();
        String current = destination;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        System.out.println("\nShortest Distance: "
                + dist.get(destination) + " km");

        System.out.println("Path: "
                + String.join(" -> ", path));
    }
}

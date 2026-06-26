package com.routefinder.routefinder.graph;

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

    public static DijkstraResult findShortestPath(
            Graph graph,
            String source,
            String destination) {

        Map<String, List<Edge>> adj =
                graph.getAdjacencyList();

        Map<String, Integer> dist =
                new HashMap<>();

        Map<String, String> parent =
                new HashMap<>();

        for (String city : adj.keySet()) {
            dist.put(city, Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                n -> n.distance));

        dist.put(source, 0);
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            if (!adj.containsKey(current.city))
                continue;

            for (Edge edge : adj.get(current.city)) {

                int newDistance =
                        dist.get(current.city)
                                + edge.getDistance();

                if (newDistance <
                        dist.getOrDefault(
                                edge.getDestination(),
                                Integer.MAX_VALUE)) {

                    dist.put(
                            edge.getDestination(),
                            newDistance);

                    parent.put(
                            edge.getDestination(),
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

            return new DijkstraResult(
                    -1,
                    new ArrayList<>());
        }

        List<String> path =
                new ArrayList<>();

        String current =
                destination;

        while (current != null) {

            path.add(current);

            current =
                    parent.get(current);
        }

        Collections.reverse(path);

        return new DijkstraResult(
                dist.get(destination),
                path);
    }
}
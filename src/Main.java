package Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        try {

            Connection con = DatabaseConnection.getConnection();

            String query =
                    "SELECT source, destination, distance FROM roads";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                String source = rs.getString("source");
                String destination = rs.getString("destination");
                int distance = rs.getInt("distance");

                graph.addRoad(
                        source,
                        destination,
                        distance
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error:");
            e.printStackTrace();
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source city: ");
        String sourceCity = sc.nextLine();

        System.out.print("Enter destination city: ");
        String destinationCity = sc.nextLine();

        Dijkstra.findShortestPath(
                graph,
                sourceCity,
                destinationCity
        );

        sc.close();
    }
}
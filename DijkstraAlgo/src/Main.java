import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a graph
        Map<String, List<Node>> graph = new HashMap<>();

        // Add nodes to the graph
        graph.put("A", Arrays.asList(new Node("B", 5), new Node("C", 2)));
        graph.put("B", Arrays.asList(new Node("A", 5), new Node("C", 3)));
        graph.put("C", Arrays.asList(new Node("A", 2), new Node("B", 3)));

        // Find the shortest path from A to C
        Node start = new Node("A");
        Node end = new Node("C");
        List<Node> shortestPath = Dijkstra.dijkstra(graph, start, end);

        // Print the shortest path
        for (Node node : shortestPath) {
            System.out.print(node.name + " ");
        }
    }
}
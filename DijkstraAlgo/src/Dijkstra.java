
import java.util.*;

public class Dijkstra {
    public static List<Node> dijkstra(Map<String, List<Node>> graph, Node start, Node end){
        // Create a set of settled nodes and an unordered set of unsettled nodes
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        // Add the start node to the unsettled nodes set
        unsettledNodes.add(start);
        // While there are unsettled nodes
        while (!unsettledNodes.isEmpty()) {

            // Find the node with the shortest distance from the start node
            Node currentNode = Collections.min(unsettledNodes, (node1, node2) -> node1.distance - node2.distance);

            // If the current node is null, then return an empty list
            if (currentNode == null) {
                return new ArrayList<>();
            }

            // Mark the current node as settled
            settledNodes.add(currentNode);

            // Remove the current node from the unsettled nodes set
            unsettledNodes.remove(currentNode);

            // For each neighbor of the current node
            for (Node neighbor : graph.get(currentNode.name)) {

                // If the neighbor is not settled
                if (!settledNodes.contains(neighbor)) {

                    // Calculate the new distance to the neighbor
                    int newDistance = currentNode.distance + neighbor.distance;

                    // If the new distance is shorter than the current distance to the neighbor
                    if (newDistance < neighbor.distance) {

                        // Update the neighbor's distance
                        neighbor.distance = newDistance;

                        // Add the neighbor to the unsettled nodes set
                        unsettledNodes.add(neighbor);
                    }
                }
            }
        }
        // Return the shortest path from the start node to the end node
        return getShortestPath(start, end);
    }

    public static List<Node> getShortestPath(Node start, Node end) {

        // Create a list to store the nodes in the shortest path
        List<Node> shortestPath = new ArrayList<>();

        // Start at the end node
        Node currentNode = end;

        // While the current node is not the start node
        while (!currentNode.equals(start)) {

            // Add the current node to the shortest path
            shortestPath.add(currentNode);

            // Set the current node to its predecessor
            currentNode = currentNode.predecessor;
        }

        // Reverse the order of the shortest path
        Collections.reverse(shortestPath);

        // Return the shortest path
        return shortestPath;
    }
}

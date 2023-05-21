import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int v = 8;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        Graph graph = new Graph(adjList);

        for (int i = 0; i < v; i ++){
            adjList.add(new ArrayList<>());
        }

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);

        int source = 0, destination = 7;
        graph.printShortestDistance(source, destination, v);
    }
}
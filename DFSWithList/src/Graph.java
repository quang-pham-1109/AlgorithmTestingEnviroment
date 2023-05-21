import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<ArrayList<Integer>> adjList;
    int v;

    public Graph(ArrayList<ArrayList<Integer>> adjList) {
        this.adjList = adjList;
        v = adjList.size();
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    //print path of destination and source using dfs
    public void printPath(int source, int destination, int v, boolean[] visited) {
        //mark the source as visited
        visited[source] = true;

        //check if visited vertex is the destination
        if (source == destination) {
            System.out.println("The path is: ");
            for (int i = 0; i < v; i++) {
                if (visited[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        //Check for adjacent vertices
        for (int i = 0; i < adjList.get(source).size(); i++) {
            int vertex = adjList.get(source).get(i);
            if (!visited[vertex]) {
                printPath(vertex, destination, v, visited);
            }
        }
    }
}

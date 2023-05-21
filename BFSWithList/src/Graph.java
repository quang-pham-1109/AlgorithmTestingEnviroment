import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Graph {
    ArrayList<ArrayList<Integer>> adjList;

    public Graph(ArrayList<ArrayList<Integer>> adjList) {
        this.adjList = adjList;
    }

    //function to add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void printShortestDistance(int source, int destination, int v) {
        //array to store the previously visited vertex
        //and distance from the source to destination
        int pred[] = new int[v];
        int dist[] = new int[v];

        if (!BFS(adjList, source, destination, v, pred, dist)) {
            System.out.println("The two vertices are not connected");
            return;
        }

        //Linked list to store the path
        LinkedList<Integer> path = new LinkedList<>();
        int crawl = destination;
        path.add(crawl);

        while (pred[crawl] != -1){
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
        Collections.reverse(path);

        //print distance
        System.out.println("Shortest path length is: " + dist[destination]);

        //print path
        System.out.println("Path is: ");
        for (Integer integer : path) {
            System.out.print(integer + " ");
        }
    }

    public boolean BFS(ArrayList<ArrayList<Integer>> adj,
                       int source, int destination, int v,
                       int pred[], int dist[]){
        //a queue to maintain vertices whose adjacency list
        //is going to be scanned
        LinkedList<Integer> queue = new LinkedList<>();

        //boolean array stores information if the ith
        //vertex is visited or not
        boolean visited[] = new boolean[v];

        //initially all vertices are unvisited
        //so are visited[] are left as false
        //no distance so dist[] are set as infinity
        //no path is constructed yet so pred[] is -1
        for (int i = 0; i < v; i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        //visit the source first, distance from source is 0
        visited[source] = true;
        dist[source] = 0;
        queue.add(source);

        //BFS Algorithm
        while (!queue.isEmpty()){
            int u = queue.remove(); //remove and get the
            for (int i = 0; i < adj.get(u).size(); i++){
                //if the neighbors are not yet visited
                if(!visited[adj.get(u).get(i)]){
                    visited[adj.get(u).get(i)] = true; //set neighbors vertices as visited
                    dist[adj.get(u).get(i)] = dist[u] + 1; //increment the distance
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    //stopping condition when the destination is found
                    if (adj.get(u).get(i) == destination){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

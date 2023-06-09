
import java.util.*;

public class Dijkstra {
    public static int V = 5;

    //function to find the vertices with shortest distance
    //that does not include in the minimum spanning tree
    public int minDistance(int dist[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++){
            if (!sptSet[v] &&
                dist[v] <= min){
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    //function to output the result
    public void printSolution(int dist[], int prev[]){
        System.out.println("Vertex \t Distance from source \t Previous vertex");
        for (int i = 0; i < V; i++){
            System.out.println(i + " \t\t " + dist[i] + " \t\t\t\t\t\t" + prev[i]);
        }
    }

    public void printShortestPath(int pred[], int des, int src){
        LinkedList<Integer> path = new LinkedList<>();
        int crawl = des;
        path.add(crawl);

        while (pred[crawl] != src){
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
        path.add(src);

        Collections.reverse(path);

        System.out.println("Path is: ");
        for (Integer integer : path) {
            System.out.print(integer + " ");
        }
    }

    public void dijkstra(int graph[][], int src, int des){
        //output array, holds all the distances from src to node i
        int dist[] = new int[V];

        //array that holds all the nodes, will initially set as false
        //will be true if the nodes are visited
        Boolean sptSet[] = new Boolean[V];

        //array that holds all the previously visited nodes
        //will be used to backtrack the shortest path
        int[] prev = new int[V];

        //Initialize all distances as infinite and sptSet array as false
        for (int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        //Distance of source vertex is set as 0
        dist[src] = 0;

        //Find shortest path for all vertices
        //Loop to V - 1 because the first vertex is already processed
        for (int i = 0; i < V - 1; i++){
            //Pick the minimum distance vertex from the set of unprocessed vertices
            //u is equal to the first vertex in the first iteration
            int u = minDistance(dist, sptSet);

            //mark the picked vertex as processed
            sptSet[u] = true;

            //update the distance value of adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++){
                //Update dist[v] if vertex is not in sptSet
                //and there is an edge from u to v
                //and total weight of path from source to v
                //through u is smaller than current dist[v]
                if (!sptSet[v] &&
                    graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }
        //output solution
        printSolution(dist, prev);
        printShortestPath(prev, des, src);
    }
}

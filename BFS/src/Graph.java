import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<Node> nodes = new ArrayList<>();
    int[][] matrix;

    public Graph(int size) {
        matrix = new int[size][size];
    }
    public void addNode(Node node) {
        nodes.add(node);
    }
    public void addEdge(int src, int des){
        matrix[src][des] = 1; //there's an edge between 2 nodes
    }
    public boolean checkEdge(int src, int des){
        return matrix[src][des] == 1;
    }
    public void print(){
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public void breathFirstSearch(int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.add(src);
        visited[src] = true;

        while (queue.size() != 0) {
            src = queue.poll();
            System.out.println(nodes.get(src).getData() + " = visited");

            for (int i = 0; i < matrix[src].length; i++){
                if(matrix[src][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

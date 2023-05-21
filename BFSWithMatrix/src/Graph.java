import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int[][] matrix;

    public Graph(int[][] matrix) {
        this.matrix = matrix;
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
            System.out.println(src + " = visited");

            for (int i = 0; i < matrix[src].length; i++){
                if(matrix[src][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

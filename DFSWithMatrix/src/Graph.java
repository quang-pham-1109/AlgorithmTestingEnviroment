import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class Graph {
    int[][] matrix;
    int v;

    public Graph(int[][] matrix) {
        this.matrix = matrix;
        v = matrix.length;
    }

    public void deptFirstSearch(int src) {
        boolean[] visited = new boolean[v];
        DFSHelper(src, visited);
    }

    private void DFSHelper(int src, boolean[] visited) {
        //if a vertex is visited, the function is returned
        if (visited[src]) {
            return;
        }
        //if a vertex is not visited, it is marked as visited
        else {
            visited[src] = true; //mark the vertex as visited
            System.out.println(src + " = visited");
        }

        for (int i = 0; i < v; i++) {
            //visit adjacent vertices of the current vertex
            if (matrix[src][i] == 1) {
                DFSHelper(i, visited);
            }
        }
    }
}

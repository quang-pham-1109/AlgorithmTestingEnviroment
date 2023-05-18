import java.util.ArrayList;

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

    public void deptFirstSearch(int start) {
        boolean[] visited = new boolean[nodes.size()];
        DFSHelper(start, visited);
    }

    private void DFSHelper(int start, boolean[] visited) {
        if(visited[start]) {
            return;
        } else {
            visited[start] = true;
            System.out.println(nodes.get(start).getData() + " = visited");
        }

        for (int i = 0; i < matrix[start].length; i++ ){
            System.out.println(matrix[start].length);
            if (matrix[start][i] == 1){
                DFSHelper(i, visited);
            }
        }
    }
}

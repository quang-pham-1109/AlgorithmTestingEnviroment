public class Main {
    public static void main(String[] args) {

        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0}
        };

        Graph graph = new Graph(graphMatrix);

        graph.deptFirstSearch(0);
    }
}
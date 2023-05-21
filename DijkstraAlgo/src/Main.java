import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] adjMatrix = {
                {0, 6, 0, 1, 0},
                {6, 0, 5, 2, 2},
                {0, 5, 0, 0, 5},
                {1, 2, 0, 0, 1},
                {0, 2, 5, 1, 0}
        };

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(adjMatrix, 0, 4);
    }
}
import java.util.List;

public class Node {
    String name;
    int distance;
    Node predecessor;

    public Node(String name, int weight) {
        this.name = name;
        this.distance = weight;
        this.predecessor = null;
    }

    public Node(String name) {
        this.name = name;
    }
}


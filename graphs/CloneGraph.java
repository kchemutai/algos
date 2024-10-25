package graphs;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    // recursive solution
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }

    private Node dfs(Node root, Map<Node, Node> oldToNew) {
        if (oldToNew.containsKey(root))
            return oldToNew.get(root);
        Node copy = new Node(root.val);
        oldToNew.put(root, copy);
        for (Node neighbour : root.neighbors) {
            copy.neighbors.add(dfs(neighbour, oldToNew));
        }
        return copy;
    }
}

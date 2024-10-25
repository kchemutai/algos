package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class CloneGraph {

    // recursive solution using DFS
    /*
     * public Node cloneGraph(Node node) {
     * if (node == null)
     * return null;
     * Map<Node, Node> oldToNew = new HashMap<>();
     * return dfs(node, oldToNew);
     * }
     */
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

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> oldToNew = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        oldToNew.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node copy = oldToNew.get(current);
            for (Node neighbor : current.neighbors) {
                Node newNode;
                if (oldToNew.containsKey(neighbor)){
                   newNode = oldToNew.get(neighbor);
                }
                else{
                    queue.add(neighbor);
                    newNode = new Node(neighbor.val);
                    oldToNew.put(neighbor, newNode);
                }
                copy.neighbors.add(newNode);
            }

        }
        return oldToNew.get(node);
    }

}

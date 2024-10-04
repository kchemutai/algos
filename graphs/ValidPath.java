package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidPath {
    static public boolean validPath(int n, int[][] edges, int source, int destination) {
        // create an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            if (!graph.containsKey(src)) {
                graph.put(src, new ArrayList<Integer>());
            }
            if (!graph.containsKey(dest)) {
                graph.put(dest, new ArrayList<Integer>());
            }
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        while (!stack.isEmpty()) {
            int src = stack.pop();
            if (visited.contains(src))
                continue;
            if (src == destination)
                return true;
            visited.add(src);

            for (int dest : graph.get(src)) {
                if (visited.contains(dest))
                    continue;
                stack.add(dest);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        System.out.println(validPath(3, edges, 0, 2));
    }
}

package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NetworkDelayTime {
    static public int networkDelayTime(int[][] times, int n, int k) {
        // create an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int source = time[0], destination = time[1], weight = time[2];
            if (!graph.containsKey(source)) {
                graph.put(source, new LinkedList<int[]>());
            }
            graph.get(source).add(new int[] { destination, weight });
        }

        // create a visited set
        Set<Integer> visited = new HashSet<>();

        // create a minHeap
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int time = 0;

        minHeap.offer(new int[] { k, 0 });

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int source = top[0], srcWeight = top[1];
            if (visited.contains(source))
                continue;
            visited.add(source);
            time = srcWeight;
            if (!graph.containsKey(source))
                continue;
            for (int[] edge : graph.get(source)) {
                int dest = edge[0], tarWeight = edge[1];
                minHeap.offer(new int[] { dest, srcWeight + tarWeight });
            }
        }

        return visited.size() == n ? time : -1;
    }

    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        System.out.println(networkDelayTime(times, 4, 2));
    }
}

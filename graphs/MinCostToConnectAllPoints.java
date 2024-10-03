package graphs;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints {
    static public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.offer(new int[] { 0, 0 }); // {source, weight}
        boolean[] visited = new boolean[points.length];
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int vertex = current[0];
            int distance = current[1];
            if (visited[vertex])
                continue;

            cost += distance;
            visited[vertex] = true;

            // add edges
            for (int i = 0; i < points.length; i++) {
                if (visited[i])
                    continue;
                int eDistance = Math.abs(points[i][0] - points[vertex][0]) + Math.abs(points[i][1] - points[vertex][1]);
                minHeap.offer(new int[] { i, eDistance });
            }

        }
        return cost;
    }

    public static void main(String[] args) {
        int[][] points = { { 3, 12 }, { -2, 5 }, { -4, 1 } };
        System.out.println(minCostConnectPoints(points));
    }
}
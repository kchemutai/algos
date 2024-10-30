package graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    static public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0 || heights[0].length == 0)
            return new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            dfs(row, 0, heights, heights[row][0], pacific);
            dfs(row, cols - 1, heights, heights[row][cols - 1], atlantic);
        }

        for (int col = 0; col < cols; col++) {
            dfs(0, col, heights, 0, pacific);
            dfs(rows - 1, col, heights, 0, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }
        return result;
    }

    static private void dfs(int row, int col, int[][] heights, int previous, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length || visited[row][col]
                || heights[row][col] < previous)
            return;
        visited[row][col] = true;
        previous = heights[row][col];
        dfs(row + 1, col, heights, previous, visited);
        dfs(row - 1, col, heights, previous, visited);
        dfs(row, col + 1, heights, previous, visited);
        dfs(row, col - 1, heights, previous, visited);
    }

    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };

        System.out.println(pacificAtlantic(heights));
    }
}
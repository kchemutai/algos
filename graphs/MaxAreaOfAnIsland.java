package graphs;

public class MaxAreaOfAnIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    maxArea = maxArea + dfs(grid, row, col);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
            return 0;
        grid[row][col] = 0;
        return 1
                + dfs(grid, row, col - 1) // process the left
                + dfs(grid, row - 1, col) // process the top
                + dfs(grid, row, col + 1) // process the right
                + dfs(grid, row + 1, col); // process the bottom
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };

        System.out.println(maxAreaOfIsland(grid));
    }
}

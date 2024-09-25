package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshOrages = 0;
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1)
                    freshOrages++;
                if (grid[row][col] == 2) {
                    queue.add(new int[] { row, col });
                }
            }
        }

        while (!queue.isEmpty() && freshOrages > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int row = arr[0];
                int col = arr[1];
                // //iterate through the neighbours
                // //left
                // if(col-1 > 0){
                // if(grid[row][col-1] == 1){
                // queue.add(new int[]{row, col-1});
                // grid[row][col-1]=2; //mark it as rotten
                // freshOrages--; //decrease the rotten oranges
                // }
                // }
                // //right
                // if(col+1 < cols){
                // if(grid[row][col+1] == 1){
                // queue.add(new int[]{row, col+1});
                // grid[row][col+1]=2; //mark it as rotten
                // freshOrages--; //decrease the rotten oranges
                // }
                // }

                // //top
                // if(row-1 > 0){
                // if(grid[row-1][col] == 1){
                // queue.add(new int[]{row-1, col});
                // grid[row-1][col]=2; //mark it as rotten
                // freshOrages--; //decrease the rotten oranges
                // }
                // }

                // //bottom
                // if(row+1 < rows){
                // if(grid[row+1][col] == 1){
                // queue.add(new int[]{row+1, col});
                // grid[row+1][col]=2; //mark it as rotten
                // freshOrages--; //decrease the rotten oranges
                // }
                // }

                for (int[] direction : directions) {
                    int r = row + direction[0], c = col + direction[1];
                    if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == 1) {
                        queue.add(new int[] { r, c });
                        grid[r][c] = 2;
                        freshOrages--;
                    }
                }
            }
            minutes++;
        }

        return freshOrages == 0 ? minutes : -1;
    }
}
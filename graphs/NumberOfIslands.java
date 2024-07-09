public class NumberOfIslands {
    static public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] visited = new boolean[n][m];
        int numberOfIslands=0;
        for(int row=0;row<n;row++){
            for(int col=0;col< m;col++){
                if(!visited[row][col] && grid[row][col] == '1'){
                    dfs(grid, row, col, visited);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    static public void dfs(char[][] grid, int row, int col, boolean [][] visited){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||visited[row][col]||grid[row][col]=='0') return;
        visited[row][col]=true;
        dfs(grid, row, col-1, visited); //process the left
        dfs(grid, row-1, col, visited); //process the top
        dfs(grid, row, col+1, visited); //process the right
        dfs(grid, row+1, col, visited); //process the bottom
    }

    public static void main(String[] args) {
        char [][] grid = {
                            {'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '1'}
                            };
        System.out.println(numIslands(grid));
    }
}
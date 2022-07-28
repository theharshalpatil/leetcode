/** DFS
 * Mark all the 1's rechable from border as 0
 * Count the remaining 1's - these will be unreachable
 * TC: O(M*N)
 * SC: O(1)
 */
class Solution {
    int rows, cols;
    public int numEnclaves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][cols-1] == 1) dfs(grid, i, cols-1);
        }
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 1) dfs(grid, 0, i);
            if (grid[rows-1][i] == 1) dfs(grid, rows-1, i);
        }
        
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }
    
    public void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) return;
        grid[r][c] = 0;
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}

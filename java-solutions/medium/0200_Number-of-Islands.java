/** Depth-First Search
 * Whenever we see a '1', do a dfs and mark all connected 1's as 0. Inc ans
 * TC: O(N*M)
 * SC: O(1)
 */
class Solution {
    int rows, cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int ans = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans += 1;
                }
            }
        }
        return ans;
    }
    
    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}

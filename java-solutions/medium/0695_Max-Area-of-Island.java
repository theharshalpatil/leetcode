/**
 * Depth First Search on each cell where we encounter a 1.
 * We check in all four directions if the 1's are surronded by 0.
 * Mark all the checked blocks as seen to avoid rechecks
 * TC: O(M * N)     -> Even with DFS, we're not recalculating seen blocks
 * SC: O(M * N)     -> Storing seen blocks
 *
 * Further optimiztions: Instead of using seen, just mark cell as 0 once seen / Don't pass grid in function call
 */
class Solution {
    boolean[][] seen;
    int ans = 0, m, n;
    
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!seen[i][j] && grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j, grid));
                }
            }
        }
        
        return ans;
    }
    
    public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (seen[i][j] == true) return 0;
        seen[i][j] = true;
        
        if (grid[i][j] == 0) return 0;
        return 1 + dfs(i-1, j, grid) + dfs(i+1, j, grid)
                 + dfs(i, j-1, grid) + dfs(i, j+1, grid);
    }
}
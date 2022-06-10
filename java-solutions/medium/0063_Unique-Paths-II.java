/** Dynamic Programming
 * Any point on right end / bottom has only one way to reach goal
 * Any other point can be filled as (No. of ways from right + No. of ways from bottom)
 * We keep Number of ways from a position to reach goal as 0 if it has a obstacle on it
 * We start filling from Goal to Init position and then return the value at Init position
 * TC: O(M*N)
 * SC: O(M*N)
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        if (obstacleGrid[rows - 1][cols - 1] == 1) return 0;
        
        // initialize grid
        int[][] grid = new int[rows + 1][cols + 1];
        grid[rows - 1][cols - 1] = 1;
        
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (r == rows - 1 && c == cols - 1) continue;
                if (obstacleGrid[r][c] == 0)
                    grid[r][c] = grid[r+1][c] + grid[r][c+1];
            }
        }
        
        return grid[0][0];
    }
}
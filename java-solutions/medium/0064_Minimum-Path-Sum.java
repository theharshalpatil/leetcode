/** Dynamic Programming
 * Refer comments for intuition
 * TC: O(M*N)   -> Each cell will be visited once
 * SC: O(1)     -> Grid is modified inplace
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        
        // last col can only be summed upwards and last row downwards
        for (int i = rows - 2; i >= 0; i--) grid[i][cols-1] += grid[i+1][cols-1];
        for (int i = cols - 2; i >= 0; i--) grid[rows-1][i] += grid[rows-1][i+1];
        
        // all other cells are += Min(right, bottom) cell
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
            }
        }
        
        // first cell will have the min sum value
        return grid[0][0];
    }
}
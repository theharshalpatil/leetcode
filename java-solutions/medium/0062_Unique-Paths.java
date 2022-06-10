/** Dynamic Programming
 * Any point on right end / bottom has only one way to reach goal
 * Any other point can be filled as (No. of ways from right + No. of ways from bottom)
 * We start filling from Goal to Init position and then return the value at Init position
 * TC: O(M*N)
 * SC: O(M*N)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[m - 1][n - 1] = 1;
        
        // Right end & Bottom have only one unique path
        for (int i = 0; i < m-1; i++) grid[i][n - 1] = 1;
        for (int i = 0; i < n-1; i++) grid[m - 1][i] = 1;
        
        // Fill remainder of grid
        for (int r = m - 2; r >= 0; r--) {
            for (int c = n - 2; c >= 0; c--) {
                grid[r][c] = grid[r+1][c] + grid[r][c+1];
            }
        }
        
        return grid[0][0];
    }
}

/** Permutations & Combinations
 * We've to basically take (M-1) steps to bottom and (N-1) steps to right
 * No. of ways to do so = [(N-1)+(M-1)]! / [(N-1)! * (M-1)!]
 * TC: O(N + M)     -> To calculate factorial, then O(1) for ans
 * SC: O(N + M)     -> For factorial memoization
 *
 * NOTE: Fails on leetcode due to int/long primitive type
 *      as it resets value to negative after max val
 */
class Solution {
    public int uniquePaths(int m, int n) {
        long[] fact = new long[m + n - 1];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) fact[i] = fact[i - 1] * i;
        
        return (int)(fact[m + n - 2] / (fact[m - 1] * fact[n - 1]));
    }
}
/**
 * Recurrsion and Memoization
 * Make a move and check the number of ways we can go out of boundary from here.
 * To avoid checking for same combinations again, memoize the solution
 * TC: O(mn*maxMove)
 * SC: O(mn*maxMove)
 */
class Solution {
    int MOD = 1000000007;
    int[][][] dp;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[maxMove + 1][m][n];
        for (int[][] l: dp) for (int[] sl: l) Arrays.fill(sl, -1);
        
        return dfs(m, n, maxMove, startRow, startColumn);
    }
    
    public int dfs(int m, int n, int maxMove, int r, int c) {
        if (r < 0 || c < 0 || r == m || c == n) return 1;
        if (maxMove == 0) return 0;
        if (dp[maxMove][r][c] >= 0) return dp[maxMove][r][c];
        
        dp[maxMove][r][c] = ((dfs(m, n, maxMove - 1, r-1, c)
                          + dfs(m, n, maxMove - 1, r+1, c)) % MOD
                          + (dfs(m, n, maxMove - 1, r, c-1)
                          + dfs(m, n, maxMove - 1, r, c+1)) % MOD) % MOD;
        return dp[maxMove][r][c];
    }
}

/**
 * Space optimization can be done by using only MxN array for memoization and remembering
 * ans for each 'number of moves' starting from 1.
 * TC: O(mn*maxMoves)
 * SC: O(mn)
 */
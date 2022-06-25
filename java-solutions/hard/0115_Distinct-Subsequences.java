/**
 * At every match between s & t we've two choices:
 *      1. consider the match and move ptr of s & t both by one
 *      2. not consider the match and move s ptr by one and keep tptr as it is
 * If it's not a match only one choice: keep tptr as it is and move sptr
 * TO avoid recalculation from a specific (sptr, tptr) state, we cache the results
 * TC: O(N * M)
 * SC: O(N * M)
 *
 * NOTE: We need only prev dp[] row. so we can have two int[] to have prev & curr dp
 *      This reduces SC to O(2*M)
 */
class Solution {
    int[][] dp;
    String s, t;
    
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) return 0;
        if (t.length() == 0) return 1;
        
        this.s = s;
        this.t = t;
        
        dp = new int[s.length()][t.length()];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        
        return dfs(0, 0);
    }
    
    public int dfs(int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dfs(i+1, j) + dfs(i+1, j+1);
        } else {
            dp[i][j] = dfs(i+1, j);
        }
        
        return dp[i][j];
    }
}
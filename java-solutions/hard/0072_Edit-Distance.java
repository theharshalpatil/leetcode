/** Dynamic Programming
 * IF (w[i] == w[j]):
 *      solve (i+1, j+1)
 * ELSE take 1 + MIN of:
 *      solve (i, j+1)  -> insert operation
 *      solve (i+1, j)  -> delete operation
 *      solve (i+1, j+1)-> replace operation
 * TC: O(N*M)
 * SC: O(N*M)
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        
        // init first row/col as base case
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) dp[i][0] = i;
        for (int i = 1; i <= len2; i++) dp[0][i] = i;
        
        
        // Build DP matrix - implemented as top-down for simplicity
        // Intuition follows from bottom-up
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],
                                       Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        
        return dp[len1][len2];
    }
}
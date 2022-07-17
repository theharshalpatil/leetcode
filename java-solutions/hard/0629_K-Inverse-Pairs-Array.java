/**
 * Recursion and memoization
 * We leverage the idea that, to add 1 inversion in a array of N having k-1 inversions, we need to insert N+1 in the second last position
 * ||arly, to add 2 inversion in a array of N having k-2 inversions, we need to insert N+1 in the third last position.. so on so forth
 * TC: O(N*k * min(N, k))       -> kInversePair is called 'Nk' times. each time a loop runs for min(N, k) times
 * SC: O(N*k)                   -> memo matrix
 *
 * TLE on Leetcode!
 */
public class Solution {
    Integer[][] memo = new Integer[1001][1001];
    public int kInversePairs(int n, int k) {
        if (n == 0)
            return 0;
        if (k == 0)
            return 1;
        if (memo[n][k] != null)
            return memo[n][k];
        int inv = 0;
        for (int i = 0; i <= Math.min(k, n - 1); i++)
            inv = (inv + kInversePairs(n - 1, k - i)) % 1000000007;
        memo[n][k] = inv;
        return inv;
    }
}

/** Dynamic Programming
 * If we have solution for all 'k' till N-1, we can calculate for N -> suggesting DP
 * TC: O(N*k * min(N, k))       -> Same as prev
 * SC: O(N*k)
 * Again, TLE
 */
public class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) dp[i][j] = 1;
                else {
                    for (int p = 0; p <= Math.min(j, i-1); p++)
                        dp[i][j] = (dp[i][j] + dp[i-1][j-p]) % 1000000007;
                }
            }
        }
        return dp[n][k];
    }
}

/** Dyanmic Programming with Cumulative sum
 * Same as above but instead of iteratively calculating dp[i][j] we just
 * add dp[i][j-1] to dp[i-1][j] and remove dp[i-1][j-1] / 0
 * TC: O(N*k)   -> Saved the internal for loop
 * SC: O(N*k)
 * NOTE: This can also be used with memoization
 */
public class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        int M = 1000000007;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) dp[i][j] = 1;
                else {
                    int val = (dp[i-1][j] + M - ((j - i) >= 0 ? dp[i-1][j-i] : 0)) % M;
                    dp[i][j] = (dp[i][j-1] + val) % M;
                }
            }
        }
        return ((dp[n][k] + M - (k > 0 ? dp[n][k-1] : 0)) % M);
    }
}

/** DP Cumulative Sum - Optimized Space
 * Notice now only one previous row of dp matrix is used, we can serve that with simple array
 * TC: O(N*k)
 * SC: O(k)
 */
public class Solution {
    public int kInversePairs(int n, int k) {
        int[] dp = new int[k+1];
        int M = 1000000007;
        
        for (int i = 1; i <= n; i++) {
            int[] temp = new int[k+1];
            temp[0] = 1;
            for (int j = 1; j <= k; j++) {
                int val = (dp[j] + M - ((j - i) >= 0 ? dp[j-i] : 0)) % M;
                temp[j] = (temp[j-1] + val) % M;
            }
            dp = temp;
        }
        return ((dp[k] + M - (k > 0 ? dp[k-1] : 0)) % M);
    }
}
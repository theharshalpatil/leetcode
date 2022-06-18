/**
 * Get a cumulative sum on each row. Compare it with currently held maxWealth
 * TC: O(M * N)
 * SC: O(1)
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int i = 0; i < accounts.length; i++) {
            int curr = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                curr += accounts[i][j];
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
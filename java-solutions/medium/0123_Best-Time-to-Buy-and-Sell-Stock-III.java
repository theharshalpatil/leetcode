/**
 * We can create a state machine to simulate the maximum profit we can obtain
 * Details: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/2277045/State-Machine-Solution-with-diagram
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int x = 0, y = -prices[0], z = 0, a = -prices[0], b = 0;
        int y_last = y, z_last = z, a_last = a;
        
        for (int i = 1; i < n; i++) {
            y = Math.max(y_last, -prices[i]);
            z = Math.max(z_last, y_last + prices[i]);
            a = Math.max(a_last, z_last - prices[i]);
            b = Math.max(b, a_last + prices[i]);
            y_last = y; z_last = z; a_last = a;
        }
        
        return Math.max(x, Math.max(y, Math.max(z, Math.max(a, b))));
    }
}
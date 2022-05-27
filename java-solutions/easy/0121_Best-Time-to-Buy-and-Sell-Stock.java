/**
 * We start looking from behind (back in time) to find sell point
 * Sell point shall be fixed at the seen so far
 * Buy point shall be rolled backwards one at a time to check:
 *  buy > sell -> new sell point; buy < sell -> check and update max
 * TC: O(n) -> we look at each day's price once
 * SC: O(1) -> No auxillary space required
 */
class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices.length - 2, sell = prices.length - 1;
        int ans = 0;
        while (buy >= 0) {
            if (prices[buy] == prices[sell]) buy--;
            else if (prices[buy] > prices[sell]) {
                sell = buy;
                buy--;
            }
            else {
                ans = Math.max(ans, prices[sell]-prices[buy]);
                buy--;
            }
        }
        return ans;
    }
}
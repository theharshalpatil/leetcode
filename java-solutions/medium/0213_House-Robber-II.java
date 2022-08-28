/**
 * Since last and first house are connected, you can either loot from [1, N-1] OR [0, N-2]
 * Then the problem is that of a House Robber
 * TC: O(N)
 * SC: O(1)     -> Not using DP array, instead two variables
 */
class Solution {
    public int rob(int[] N) {
        if (N.length == 1) return N[0];
        
        return Math.max(getAmount(N, 0, N.length-1),
                        getAmount(N, 1, N.length));
    }
    
    public int getAmount(int[] nums, int start, int end) {
        int prev = 0, grandprev = 0;
        for (int i = start; i < end; i++) {
            int nopick = prev;
            int pick = nums[i] + grandprev;
            int curr = Math.max(pick, nopick);
            
            grandprev = prev;
            prev = curr;
        }
        return prev;
    }
}

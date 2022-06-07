/**
 * Initialize a arr (default -1) to store min number of steps till an idx
 * for every number in nums, go to where it reaches and update dp with min value
 * if a value is already updated in dp, it means we already have min number of steps to reach there
 * TC: O(N^2)
 * SC: O(N)
 */
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        
        int len = nums.length;
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            int j = 1;
            while (j <= nums[i] && i + j < len) {
                if (dp[i+j] == -1)
                    dp[i+j] = dp[i] + 1;
                j++;
            }
            // If you've already found min steps, no point in continuing
            if (dp[len - 1] != -1) return dp[len - 1];
        }
        
        return dp[len - 1];
    }
}

/** Simplified BFS
 * In prev approach our dp would look like [0, 1, 1, 2, 2].
 * Notice, for every range of same number, if we find the farthest we can go,
 * we know that next range would be till the farthest index.
 * TC: O(N)     -> each element is only looked at once
 * SC: O(1)     -> No extra space!
 */
 class Solution {
    public int jump(int[] nums) {
        int ans = 0, len = nums.length;
        int l = 0, r = 0;
        
        while (r < len - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            ans += 1;
        }
        
        return ans;
    }
}
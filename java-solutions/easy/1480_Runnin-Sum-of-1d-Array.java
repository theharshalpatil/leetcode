/**
 * Just maintain the sum in a seperate variable
 * TC: O(n)
 * SC: O(1)     -> not considering ans array
 */
class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int rsum = 0;
        for (int i = 0; i < nums.length; i++) {
            rsum += nums[i];
            ans[i] = rsum;
        }
        return ans;
    }
}
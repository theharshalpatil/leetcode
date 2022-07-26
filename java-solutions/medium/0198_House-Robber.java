/** Dynamic Programming
 * We store the max amount you can steal staring with i'th house and work our way to first house
 * Amount after considering i'th house = MAX(amount from i+1 th house, amount from i + amount from i+2 th house)
 * TC: O(N)     -> Check each house just once
 * SC: O(1)     -> did it in-place
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int temp = 0;
        nums[nums.length - 2] = Math.max(nums[nums.length-2], nums[nums.length-1]);
        for (int i = nums.length - 3; i >= 0; i--) {
            nums[i] = Math.max(nums[i+1], nums[i] + nums[i+2]);
        }
        
        return Math.max(nums[0], nums[1]);
    }
}

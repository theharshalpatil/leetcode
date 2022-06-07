/** Greedy
 * We start from the end and check if current index can reach the goad (end)
 * if yes, we shift our goal to the curr idx (as if we reach here, we'll surely reach the end!)
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) goal = i;
        }
        // Have we backtraced to first index?
        return (goal == 0);
    }
}
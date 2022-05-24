/** An extension to 3Sum where we check for absolute difference to determine updates
 * TC: O(N^2) -> Outer loop to fix element O(n). Two pointer to move for remaining two elements O(n)
 * SC: O(1) -> No extra space required
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        
        if (nums.length == 3) return ans;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (ans == target) break;
            int lo = i+1, hi = nums.length - 1;
            while (lo < hi) {
                int curr = nums[i] + nums[lo] + nums[hi];
                if (ans == target) return ans;
                if (Math.abs(ans - target) > Math.abs(curr - target)) {
                    ans = curr;
                }
                if (curr > target) hi--;
                else lo++;
            }
        }
        
        return ans;
    }
}
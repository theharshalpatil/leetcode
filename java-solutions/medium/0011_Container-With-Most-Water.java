/**
 * Start from two corners and start coming to the center by leaving out smaller height
 * This works as we always consider the larger of the most seperated heights
 * Most seperated heights is important factor as 'width' is directly multiplied to find the area.
 * TC: O(n) -> after each iteration we move to the next element and this is done at max arr.length times
 * SC: O(1) -> No extra space required apart from pointers and ans (which are all int)
 */
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int ans = 0;
        
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r-l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        
        return ans;
    }
}
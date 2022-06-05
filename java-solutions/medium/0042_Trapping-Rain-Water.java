/**
 * The water will be contained only if a wall has higher walls to L&R of it
 * Max water contained over the wall = Min(Max to left, Max to right) - height of wall
 * TC: O(N)     -> 3 loops to find maxL, maxR and contained water
 * SC: O(N)     -> 2 arrays to store maxL & maxR of a given wall
 */
class Solution {
    public int trap(int[] height) {
        // Maintain two arrays telling max height to L&R
        int len = height.length;
        int[] maxL = new int[len];
        int[] maxR = new int[len];
        
        for (int i = 1; i < len; i++)
            maxL[i] = Math.max(maxL[i-1], height[i-1]);
        for (int i = len-2; i >= 0; i--)
            maxR[i] = Math.max(maxR[i+1], height[i+1]);
        
        int h = 0, ans = 0;
        for (int i = 0; i < len; i++) {
            h = height[i];
            if (h < maxL[i] && h < maxR[i])
                ans += Math.min(maxL[i], maxR[i]) - h;
        }
        return ans;
    }
}
/**
 * Using an intermidiate array before rotating
 * TC: O(N)
 * SC: O(N)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        
        for (int i = 0; i < n; i++) temp[i] = nums[i];
        for (int i = 0; i < n; i++) nums[(i+k)%n] = temp[i];
    }
}

/**
 * Rotate the array one step at a time. Repeat for k-times
 * TC: O(N*k)
 * SC: O(1)
 * NOTE: TLE on Leetcode
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return;
        k = k%n;
        
        int temp = 0, swp = 0;
        while (k-- > 0) {
            temp = nums[n-1];
            for (int i = 0; i < n; i++) {
                swp = nums[i];
                nums[i] = temp;
                temp = swp;
            }
        }
    }
}

/**
 * Leverage the property that rotating is basically reversing, splitting and reversing again
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if (k == 0) return;
        
        // reverse the list
        reverse(nums, 0, n-1);
        // reverse the first half with split at 'k'
        reverse(nums, 0, k-1);
        // reverse the second half
        reverse(nums, k, n-1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        int temp;
        while (start <= end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
}

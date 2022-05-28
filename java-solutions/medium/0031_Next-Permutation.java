/**
 * We use a property of a permutation where:
 *      1. Descending elements from left, no next larger permutation is possible
 *      2. When we start from behind & encounter a smaller prev value, 
 *          we exchange the smaller value (@i) with the one that is just higher than it
 *      3. Reverse the array from (i+1) till end to get smallest possible (asc). as it's already in dsc
 * TC: O(n) -> Max two passes of array
 * SC: O(1) -> No extra space
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // traverse as long as n[i+1] <= n[i]
        int i = nums.length - 2;
        while (i >= 0 && nums[i+1] <= nums[i]) i--;
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) j--; // since from behind it shall be asc
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
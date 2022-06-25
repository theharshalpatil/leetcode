/**
 * Change only once taking care that array till now remains in non-dec order
 * And also keeping in mind that we provide enough room for remaining array to be in non-dec order
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean changed = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i+1])
                continue;
            if (changed)
                return false;
            
            // we want to change left element
            //     i, i+1
            // [3, 4, 2]
            if (i == 0 || nums[i+1] >= nums[i-1])
                nums[i] = nums[i+1];
            else
                nums[i + 1] = nums[i];
            changed = true;
        }
        
        return true;
    }
}
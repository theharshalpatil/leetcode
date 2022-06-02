/**
 * We first ignore any -ve elements as they're not to be considered
 * This is done so that we can mark an index -ve if index occurs as value in array
 * Notice, max value that can be possible as answer is (nums.length + 1)
 * So, for index having 0 in them and are seen we put -(nums.length + 1) in them
 * As a last pass, we find the first positive element and return the index as answer!
 * TC: O(3N) ~ O(N)     -> 3 passes of nums[]
 * SC: O(1)             -> No extra space needed, we leverage nums[] to store seen info
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        // -ve Numbers are of no use to us. Making them zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = 0;
        }
        
        // smallest positive number is 1
        // worst case answer would be length of nums + 1
        int min = 1, max = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if (curr > 0 && curr < max) {
                if (nums[curr - 1] == 0) nums[curr - 1] = -1*max;
                else if (nums[curr - 1] > 0) nums[curr - 1] *= -1;
            }
        }
        
        // Another pass to find first positive number
        for (int i = 1; i < max; i++) {
            if (nums[i - 1] >= 0) return i;
        }
        
        System.out.println("DOne with passes");
        return max;
    }
}
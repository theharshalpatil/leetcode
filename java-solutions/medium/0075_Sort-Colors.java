/** Bucket Sort 
 * Note number of elements of different colors
 * Run another pass to re-fill array
 * Ideal way would be to have a hashmap instead of ints
 * TC: O(N)
 * SC: O(1) // Since only 3 ints
 */
class Solution {
    public void sortColors(int[] nums) {
        int numRed = 0, numWhite = 0, numBlue = 0;
        for (int n: nums) {
            if (n == 0) numRed++;
            else if (n == 1) numWhite++;
            else if (n == 2) numBlue++;
        }
        
        int i = 0;
        while (numRed-- > 0) { nums[i] = 0; i++; }
        while (numWhite-- > 0) { nums[i] = 1; i++; }
        while (numBlue-- > 0) { nums[i] = 2; i++; }
    }
}

/** One Pass Solution
 * We use modified quick-sort with one pointer at left & right
 * if we encounter 0, swap with left. if 2, swap with right
 * NOTICE we increment our runner only if we swap 0 otherwise we check again if we've got a 0
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        int l = 0, i = 0, r = nums.length - 1;
        int temp = 0;
        
        while (i <= r) {
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++; i++;
            }
            else if (nums[i] == 2) {
                temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
            } else {
                i++;
            }
        }
    }
}
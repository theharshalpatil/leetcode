/** Two-Pointer Method
 * We maintain 'i' to traverse through the array
 * & 'pos' to stay at position where we want to update the next occurrence
 * We wait for currNum's count to reach 2 to move i untill a new currNum is encountered
 * Return the value of 'pos' as length of final meaningful array
 * TC: O(N) -> Going through array only once
 * SC: O(1) -> All operations in-place
 */
 class Solution {
    public int removeDuplicates(int[] nums) {
        int currNum = nums[0];
        int count = 0;
        int i = 0, pos = 0;
        
        while (i < nums.length) {
            if (nums[i] != currNum) {
                currNum = nums[i];
                nums[pos] = currNum;
                count = 1;
                i++; pos++;
            } else {
                nums[pos] = currNum;
                count++; i++; pos++;
                if (count == 2)
                    while (i < nums.length && currNum == nums[i]) i++;
            }
        }
        
        return pos;
    }
}
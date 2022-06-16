/** Sorting
 * Since majority element appears more than N/2 times
 * If we sort the array. Majority element will always be on N/2 idx.
 * TC: O(N logN)
 * SC: O(1)
 *
 * Other ways: Hashing #of occurrences and returning number with highest occurrence. O(N) both
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/** Boyer-Moore Voting Algorithm
 * We choose a candidate and inc count if we see it again, dec if any other number is reached
 * if count reaches 0, we pick next number as our candidate. This skipping of prefix makes sense 
 * as when count reaches 0, we're ignoring equal number of minority & majority thus maintaining majority in suffix
 * Better explaination at: https://leetcode.com/problems/majority-element/solution/
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        
        for (int n: nums) {
            if (count == 0)
                candidate = n;
            count += (n == candidate) ? 1 : -1;
        }
        
        return candidate;
    }
}
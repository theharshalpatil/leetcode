/** Bit-Manipulation
 * We're given that there's only one unique number, others are in pairs
 * If we maintain an ans int and keep xor'ing all the nums, we should be left with the unique num
 * This will happen as xor of pairs will result in 0 -> xor(n, n) = 0
 * TC: O(N)
 * SC: O(1)
 * 
 * Other ways are:
 *  1. Brute force (check for a pair for each num) -> TC: O(N^2), SC: O(1)
 *  2. Hashing (Store no of time we see a number and return the number which is seen once) -> TC: O(N), SC: O(N)
 *  3. Sorting (Sort and run to check adjuscent nums. Return the one that isn't repeating) -> TC: O(N logN), SC: O(1)
 */
class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int ans = 0;
        for (int n: nums) {
            ans ^= n;
        }
        return ans;
    }
}
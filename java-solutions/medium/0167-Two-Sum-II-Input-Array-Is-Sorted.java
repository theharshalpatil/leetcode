/**
 * Two-pointer method to find two-sum and to return idxs when found
 * TC: O(N)     -> each element visited only once
 * SC: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] ans = new int[2];
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                ans[0] = l+1;
                ans[1] = r+1;
                break;
            }
            if (numbers[l] + numbers[r] < target) l++;
            else r--;
        }
        return ans;
    }
}
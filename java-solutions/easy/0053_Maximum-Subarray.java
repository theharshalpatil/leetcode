/**
 * We maintain a rolling sum for the elements that aren't discarded upto current element
 * We maintain another max sum to store the maximum sum of a subarray upto current element
 * TC: O(n)
 * SC: O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = 0; // there's at least one element in nums
        for (int n: nums) {
            if (currSum < 0) currSum = 0; // No need to carry forward negative sum
            currSum += n;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
/**
 * Since only one number is missing from [0...n] range, we can take Summation(n)
 * and subtract all the n in nums from this sum to obtain missing number.
 * Since extra element in nums is 0, it will not affect the answer
 * TC: O(n) -> Look at all numbers once
 * SC: O(1) -> just required to store sum!
 */
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (len*(len+1))/2;
        
        for (int n: nums) {
            sum -= n;
        }
        
        return sum;
    }
}
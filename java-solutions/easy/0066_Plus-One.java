/**
 * IF a digit is 9, make it 0 and continue to prev digit
 * IF a digit is < 9, increment by one and return digits
 * When all digits complete and nothing is returned, make another array of len(digits)+1
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] ans = new int[n + 1];
        ans[0] = 1;
        for (int i = 0; i < n; i++) {
            ans[i+1] = digits[i];
        }
        return ans;
    }
}
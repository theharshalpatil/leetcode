/**
 * Loop through both strings - handle corner cases
 * The sum in a given place will be (a[i]+b[j]+carry)%10 since decimal
 * The carry will be (a[i]+b[j]+carry)/10
 * TC: O(max(M, N))
 * SC: O(1)
 */
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i) - '0';
            if (j >= 0) sum += num2.charAt(j) - '0';
            sb.append(sum%10);
            carry = sum / 10;
            i--; j--;
        }
        
        if (carry != 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
}
/**
 * Just reverse using 'long' and check if resultant is > Integer.MAX_VALUE
 * TC: O(log(N)) [base 10] // since we devide by 10 after each iteration
 * SC: O(1) // no extra space. Or say O(log10(n)) if counting the stored reversed int.
 */
class Solution {
    public int reverse(int x) {
        long rev = 0;
        boolean isNegative = (x < 0);
        
        int a = Math.abs(x);
        while (a > 0) {
            rev = rev*10 + a%10;
            a /= 10;
            if (rev > Integer.MAX_VALUE) return 0;
        }
        
        return (isNegative) ? (int) -rev : (int) rev;
    }
}
/**
 * Traverse through string and analyze each charcter one at a time.
 * Handle the cases encountered, viz., leading whitespaces, sign, numbers, remenants
 * Say 'n' is size of string passed
 * TC: O(n) -> Visit each character in string only once.
 * SC: O(1) -> long takes constant space. No other order n space used.
 */
class Solution {
    public int myAtoi(String s) {
        int len = s.length(), track = 0;
        if (len == 0) return 0;
        
        boolean sign = false; // false = postive, true = negative
        long ans = 0;
        // Ignore leading whitespaces
        while (track < len) {
            if (s.charAt(track) != ' ') break;
            track++;
        }
        
        // check if whole string wasn't whitespace
        if (track == len) return 0;
        
        // check for sign
        if (s.charAt(track) == '-') {
            sign = true;
            track++;
        }
        else if (s.charAt(track) == '+') track++;
        
        // check if string doesn't end with sign
        if (track == len) return 0;
        
        // Capture number
        while (track < len && Character.isDigit(s.charAt(track))) {
            ans = ans*10 + (int) (s.charAt(track) - '0');
            if (ans >= Integer.MAX_VALUE) break;
            track++;
        }
        
        // ignore any other remenant & clamp
        if (ans > Integer.MAX_VALUE) {
            return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        if(sign) ans *= -1;
        return (int) ans;
    }
}
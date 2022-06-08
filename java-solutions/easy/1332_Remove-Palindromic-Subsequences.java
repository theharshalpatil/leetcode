/**
 * If given string is a palindrome, we can remove it in one go
 * If not, notice string only contains 'a' & 'b' so,
 * the subsequence consisting of all a's can be removed in one go. similarly for 'b' (so max 2)
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public int removePalindromeSub(String s) {
        if (isPalindrome(s)) return 1;
        return 2;
    }
    
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
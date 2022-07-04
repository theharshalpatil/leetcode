/**
 * First make the required string then check if it's palindrome
 * TC: O(N)     -> One pass for making required string, another for checking palindrome
 * SC: O(N)     -> for SB storing required string
 */
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z'))
                sb.append(ch);
            else if (ch >= 'A' && ch <= 'Z')
                sb.append((char) (ch - 'A' + 'a'));
        }
        return checkPalindrome(sb.toString());
    }
    
    public boolean checkPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}

/**
 * Single-Pass solution
 * Skip invalid chars and check for corresponding valid chars
 * Return false if discrepancy is found
 * TC: O(N) -> one Pass
 * SC: O(1) -> no extra space required
 */
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        
        while (i <= j) {
            if (!isValid(s.charAt(i))) i++;
            else if (!isValid(s.charAt(j))) j--;
            else if (toLowerCase(s.charAt(i)) != toLowerCase(s.charAt(j))) return false;
            else {
                front.append(toLowerCase(s.charAt(i)));
                back.append(toLowerCase(s.charAt(j)));
                i++; j--;
            }
        }
        
        return true;
    }
    
    public boolean isValid(char ch) {
        if ((ch >= 'a' && ch <= 'z')
           || (ch >= 'A' && ch <= 'Z')
           || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }
    
    public char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            return (char) (ch - 'A' + 'a');
        return ch;
    }
}
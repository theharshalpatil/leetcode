/**
 * Brute Force
 * TC: O(N^3) -> O(n^2) for two pointer substring, embedded O(n) for validity
 * SC: O(1) -> No extra space required
 */
class Solution {
    public int longestValidParentheses(String s) {
        int maxValid = 0;
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if (isValid(s.substring(i, j+1))) {
                    maxValid = Math.max(maxValid, j-i+1);
                }
            }
        }
        return maxValid;
    }
    
    boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        int state = 0;
        for (char c: s.toCharArray()) {
            if (c == ')' && state == 0) return false;
            if (c == '(') state++;
            else state--;
        }
        return (state == 0) ? true : false;
    }
}

/** Using Stack
 *  We use stack to store the index of start of valid substring at bottom
 *  The same stack is used for keeping track of opening braces to pop if closing brace is encountered
 *  TC: O(N) -> each character in string is looked at once
 *  SC: O(N) -> if whole string is just opening braces
 */
 class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') st.push(i);
            else {
                st.pop();
                if (st.isEmpty()) st.push(i);
                else {
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }

        return maxLen;
    }
}

/**
 * We use another property of valid parentheses that (# of open == # of close)
 * We go two ways checking this:
 *    1. 0...n -> if we encounter extra close then the substring deems invalid.
 *    2. n...0 -> if we encounter extra open then the substring deems invalid.
 * In both cases we keep track of maxLen when (# of open == # of close)
 * TC: O(n) -> We look at each char in the string twice
 * SC: O(1) -> No extra order 'n' space is required
 */
 class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0, ob = 0, cb = 0;
        char ch;
        
        // 0 ... n
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') ob++;
            else cb++;
            
            if (ob == cb) maxLen = Math.max(maxLen, ob+cb);
            if (cb > ob) cb = ob = 0;
        }
        
        // n ... 0
        cb = ob = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ch = s.charAt(i);
            if (ch == '(') ob++;
            else cb++;
            
            if (ob == cb) maxLen = Math.max(maxLen, ob+cb);
            if (ob > cb) ob = cb = 0;
        }
        
        return maxLen;
    }
}

/**
 * Dynamic Programming: We maintain int[] to store len of longest valid substring till i'th index
 * No need to check for '('
 * Check for ')' and then two cases:
 *  1. if preceding is '(' then "....()" simply add '2' to dp[i-2]
 *  2. if preceding is ')' then "....))" check for char before valid substring, ie, at i - dp[i-1] - 1 is '('
                then again add 2 to valid string till now making dp[i-1] + dp[i - dp[i-1] - 1] + 2
 * TC: O(n) -> Go through each char in string once
 * SC: O(n) -> For the dp array
 */
 class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length(), maxLen = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = ((i >= 2) ? dp[i-2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i-1] + ((i - dp[i-1]) >= 2 ? dp[i - dp[i-1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}
/** Recursion + Memoization
 * Check for base cases in recursive function:
 *  1. s="", p=""           -> true
 *  2. s="", p="*" * N      -> true
 *  3. s="xyz", p=""        -> false
 * For other cases recurse
 *  1. s="abx", p="acd"     -> check for "bx", "cd"
 *  2. s="abx", p="?c"      -> check for "bx", "c"
 *  3. s="xus", p="*as"     -> check for ("us", "*as") & ("xus", "as")
 * NOTE: last case will also cover ("us", "as")!
 * TC: O(M * N)     -> Tree Recurrsion
 * SC: O(M * N)     -> DP Matrix
 */
class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return wm(s, p, 0, 0);
    }
    
    private boolean wm(String s, String p, int i, int j) {
        if (dp[i][j] != null) return dp[i][j];
        
        // base cases
        if (i == s.length() && j == p.length()) return true;
        if (i == s.length()) {
            for (int idx = j; j < p.length(); j++) {
                if (p.charAt(j) != '*') return false;
            }
            return true;
        }
        if (j == p.length() && i != s.length()) return false;
        
        boolean ans = false;
        if ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && wm(s, p, i+1, j+1)) {
            ans = true;
        } else if (p.charAt(j) == '*' && (wm(s, p, i, j+1) || wm(s, p, i+1, j))) {
            ans = true;
        }
        
        dp[i][j] = ans;
        return ans;
    }
}
/** Dynamic Programming
 * To find if a string is a subsequence we use DP
 * TC: O(W * N * M)     -> W = number of words to check, N = len(s), M = len(w)
 * SC: O(N * M)         -> For the DP array
 * Not very efficient! TLE on leetcode
 */
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (String word: words) {
            if (isSubSequence(s, word)) ans++;
        }
        return ans;
    }
    
    public boolean isSubSequence(String main, String check) {
        boolean[][] mat = new boolean[check.length() + 1][main.length() + 1];
        Arrays.fill(mat[0], true);
        
        for (int i = 1; i <= check.length(); i++) {
            for (int j = 1; j <= main.length(); j++) {
                if (check.charAt(i-1) == main.charAt(j-1))
                    mat[i][j] = mat[i-1][j-1];
                else
                    mat[i][j] = mat[i][j-1];
            }
        }
        
        return mat[check.length()][main.length()];
    }
}

/** Two-Pointer method
 * Why go full ballistic, when we can do it simply?
 * TC: O(W * len(s))        -> as isSubSequence will only run till len(s)
 * SC: O(len(s) + len(w))   -> to store char[]
 * Again, TLE!
 */
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (String word: words) {
            if (isSubSequence(s.toCharArray(), word.toCharArray())) ans++;
        }
        return ans;
    }
    
    public boolean isSubSequence(char[] main, char[] check) {
        int i = 0, j = 0;
        while (i < main.length && j < check.length) {
            if (main[i] == check[j]) {
                i++; j++;
            } else {
                i++;
            }
        }
        return j == check.length;
    }
}

/**
 * Same as above, but avoiding duplicate words and converting 's' to array only once
 * TC: O(W * len(s))
 * SC: O(len(s) + len(w))
 */
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) map.put(word, map.getOrDefault(word, 0) + 1);
        
        int ans = 0;
        char[] str = s.toCharArray();
        for (String word: map.keySet()) {
            if (isSubSequence(str, word.toCharArray())) ans += map.get(word);
        }
        return ans;
    }
    
    public boolean isSubSequence(char[] main, char[] check) {
        int i = 0, j = 0;
        while (i < main.length && j < check.length) {
            if (main[i] == check[j]) {
                i++; j++;
            } else {
                i++;
            }
        }
        return j == check.length;
    }
}
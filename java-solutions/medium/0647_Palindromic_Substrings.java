/**
 * Uses Dynamic Programming to keep track of number of substrings of lower lenghts.
 * To solve a problem of # of palindromes in a longer string, we solve for strings of len 1 & 2
 * All len==1 strings are palindromes and count = 1
 * For len==2 strings, we've 2 cases (eg. in comments)
 *          1. is a palindrome -> total palindromes so far = 3
 *          2. isn't a palindrome -> total palindromes so far = 2
 * All the longer string (s) problems are solved as in the last for loop
 * Our answer is the number of palindromes in s[0...(len-1)]
 */
class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        
        boolean[][] isPalin = new boolean[len][len];
        int[][] countPalin = new int[len][len];
        
        // all len==1 substrings are palindrome
        for (int i = 0; i < len; i++) {
            isPalin[i][i] = true;
            countPalin[i][i] = 1;
        }
        
        // special case for len==2
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                isPalin[i][i+1] = true;
                countPalin[i][i+1] = 3; // "aa" -> "a", "a", "aa"
            } else {
                countPalin[i][i+1] = 2; // "ab" -> "a", "b"
            }
        }
        
        // DP for len>2
        for (int gap = 2; gap < len; gap++) {
            for (int start = 0; start < len - gap; start++) {
                int end = start + gap;
                if (s.charAt(start) == s.charAt(end) && isPalin[start+1][end-1]) {
                    isPalin[start][end] = true;
                    countPalin[start][end] = countPalin[start][end-1] + countPalin[start+1][end]
                                                - countPalin[start+1][end-1] + 1;
                } else {
                    countPalin[start][end] = countPalin[start][end-1] + countPalin[start+1][end]
                                                - countPalin[start+1][end-1];
                }
            }
        }
        
        return countPalin[0][len-1];
    }
}
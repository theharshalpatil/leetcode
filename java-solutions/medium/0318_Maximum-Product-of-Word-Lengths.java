/**
 * Brute Force: for every pair of words, check if they've common letters
 * If no common letters, update maxVal
 * TC: O(n^2 * m) -> n=len(words array), m=maxlen(single word)
 * SC: O(1) -> boolean array of 26 length
 */
class Solution {
    static int MAX_CHAR = 26;
    
    public int maxProduct(String[] words) {
        int maxVal = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length; j++) {
                if (!hasCommonLetter(words[i], words[j])) {
                    maxVal = Math.max(maxVal, words[i].length()*words[j].length());
                }
            }
        }
        return maxVal;
    }
    
    private boolean hasCommonLetter(String a, String b) {
        boolean seen[] = new boolean[MAX_CHAR];
        for (char c: a.toCharArray()) {
            seen[c - 'a'] = true;
        }
        for (char c: b.toCharArray()) {
            if (seen[c - 'a']) return true;
        }
        return false;
    }
}

/** Bit-Representation Approach
 * TC: O(n^2) -> O(n) for BR, O(n^2) to check all strings
 * SC: O(n) -> to store BR for each string
 */
class Solution {
    public int maxProduct(String[] words) {
        int maxVal = 0;
        
        // For every string, we convert to a bit-representation (BR)
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                bits[i] = bits[i] | 1 << (c - 'a');
            }
        }
        
        // Logical AND of two BR tells if the corresponding strings have common letters
        for (int i = 0; i < bits.length - 1; i++) {
            for (int j = i+1; j < bits.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    maxVal = Math.max(maxVal, words[i].length() * words[j].length());
                }
            }
        }
        
        return maxVal;
    }
}
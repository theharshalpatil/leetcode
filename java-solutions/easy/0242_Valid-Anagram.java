/**
 * Anagrams should be of same length.
 * Store seen alphabets in a int[] (inc for s, dec for t)
 * If s & t are anagrams, all numbers in int[] should be 0
 * TC: O(N)
 * SC: O(1)     -> Constant int[26] space
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] seen = new int[26];
        for (int i = 0; i < s.length(); i++) {
            seen[s.charAt(i) - 'a']++;
            seen[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < seen.length; i++)
            if (seen[i] != 0) return false;
        return true;
    }
}
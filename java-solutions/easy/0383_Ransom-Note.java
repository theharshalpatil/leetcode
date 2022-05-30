/**
 * Maintain array of 26 ints (one for each alphabet) to store number of letters in mag
 * Iterate through ransomNote to find violations
 * TC: O(N + M)     -> N=len(ransomNote), M=len(magazine)
 * SC: O(1)         -> int array of len 26
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        
        int[] mag = new int[26];
        for (char c: magazine.toCharArray()) mag[c - 'a']++;
        
        for (char c: ransomNote.toCharArray()) {
            if (mag[c - 'a'] == 0) return false;
            mag[c - 'a']--;
        }
        
        return true;
    }
}
import java.util.HashMap;
import java.util.HashSet;

/**
 * First submitted solution; not optimal
 * Uses a HashMap to store seen chars but starts checking from scratch at each character (not so optimal)
 * TC: a little less than O(n^2) [since internal 'while' will run less than 'n' times even in worst case] but definitely not O(n)
 * SC: O(n) 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Boolean> seen = new HashMap<Character, Boolean>();
        int len = s.length();
        
        int longest = 0;
        for (int i = 0; i < len; i++) {
            seen.clear();
            char curr = s.charAt(i);
            int j = i;
            while (j < len && seen.get(s.charAt(j)) == null) {
                seen.put(s.charAt(j), true);
                j++;
            }
            if (longest < (j - i)) longest = j - i;
            if (longest > (len - i)) break; // sneaky break if len(remaining s) is less than longest substring found
        }
        
        return longest;
    }
}

/**
 * Sliding Window Method; Optimal as compared to first
 * Uses an optimized sliding window (adjustable length) approach to determine valid substrings.
 * TC: O(n) - traversing through string only once
 * SC: O(n) - Size of set can reach maximum to min(size of string, number of ascii chars)
 */
 class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Eliminating corner-cases
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        
        // The fun part
        HashSet<Character> used = new HashSet<Character>();
        int left = 0, ans = 0, len = s.length();
        
        for (int right = 0; right < len; right++) {
            while (used.contains(s.charAt(right))) { // remove dups from left
                used.remove(s.charAt(left));
                left++;
            }
            used.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1); // to capture max valid window size
        }
        
        return ans;
    }
}

/**
 * Sliding Window Method but with char[] sized the number of ASCII chars (128)
 * Same as previous, but uses fixed size char[] insted of Set to determine presence of a char in window
 * TC: O(n) - traversing through string only once
 * SC: O(1) - Does not use any order 'n' space
 */
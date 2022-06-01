/**
 * Have a bool array to determine if a char is previously seen.
 * If not seen, check for remaining chars and update true if encountered.
 * Before continuing with next char, check if update is done - send index if ture
 * TC: O(N^2)
 * SC: O(1)     -> arr is only len 26 (lower case alphabets)
 */
class Solution {
    public int firstUniqChar(String s) {
        boolean[] arr = new boolean[26];
        char curr;
        for (int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            if (!arr[curr - 'a']) {
                for (int j = i+1; j < s.length(); j++) {
                    if (curr == s.charAt(j)) {
                        arr[curr - 'a'] = true;
                        continue;
                    }
                }
                if (!arr[curr - 'a']) return i;
            }
        }
        return -1;
    }
}

/** Two-Pointer Method
 * Fist pointer holds the curr char if not seen and checks with 2nd pointer.
 * If second pointer reaches end, then ans is first pointer.
 * If second pointer never reaches end but no unique char, return -1.
 * TC: O(N^2)   -> worst case (Still 10x faster on leetcode)
 * SC: O(1)     -> seen is only len 26
 */
class Solution {
    public int firstUniqChar(String s) {
        int i = 0, j = 1, len = s.length();
        boolean[] seen = new boolean[26];
        while (i < len && j <= len) {
            if (j == len && !seen[s.charAt(i) - 'a']) return i;
            if (j == len) return -1;
            
            if (seen[s.charAt(i) - 'a']) {
                i++;
                j = i+1;
                continue;
            }
            if (s.charAt(i) == s.charAt(j)) {
                seen[s.charAt(i) - 'a'] = true;
                i++;
                j = i+1;
            } else {
                j++;
            }
        }
        return -1;
    }
}
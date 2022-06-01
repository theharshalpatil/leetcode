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
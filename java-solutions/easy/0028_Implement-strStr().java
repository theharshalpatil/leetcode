/**
 * we loop till hlen-nlen (if the remaining hay isn't as big as needle, there's definitely no needle!)
 * if we find needle's first char, we check for remaining chars. if found return the needles first idx
 * TC: O(M*N) -> M is hay's length, N is needle's len
 * SC: O(1)
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length(), nlen = needle.length();
        if (needle.equals("")) return 0;
        
        for (int i = 0; i <= hlen - nlen; i++) {
            int nptr = 0;
            if (needle.charAt(nptr) == haystack.charAt(i)) {
                while (nptr < nlen
                       && needle.charAt(nptr) == haystack.charAt(i+nptr)) {
                    nptr++;
                }
                if (nptr == nlen) return i;
            }
        }
        
        return -1;
    }
}
/**
 * Like a cypher, we try to find which index of original string maps to which index of output string.
 * This can be done row-wise, where for every row we capture the next char and append it to output string.
 * TC: O(n) -> We goto each character in the string only once
 * SC: O(n) -> Since we have to store the output char[]. Arguably O(1) if we don't take output string into account.
 */
 class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        int len = s.length();
        if (numRows >= len) return s;
        
        char out[] = new char[len];
        int track = 0;
        
        for (int curr = 0; curr < numRows; curr++) {
            int pos = curr;
            if (curr == 0 || curr == numRows - 1) {
                while (pos < len) {
                    out[track] = s.charAt(pos);
                    track++;
                    pos += 2*(numRows - 1);
                }
            } else {
                boolean mid = true;
                while (pos < len) { // this could be made better
                    out[track] = s.charAt(pos);
                    if (mid) {
                        pos += 2*(numRows - curr - 1);
                        mid = false;
                    } else {
                        pos += 2*(curr);
                        mid = true;
                    }
                    track++;
                }
            }
        }
    
        return new String(out);
    }
}
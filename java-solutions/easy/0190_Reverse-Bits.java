/**
 * Look at number git by git from behind and add to result from ahead
 * TC: O(1)
 * SC: O(1)
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res = res | (bit << (31 - i));
        }
        
        return res;
    }
}
/** Bit Manipulation
 * Note that power of 2 will have only one bit set!
 * TC: O(1)     -> Max 32 iterations
 * SC: O(1)
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        int setBits = 0;
        
        while (n > 0) {
            if ((n&1) == 1) setBits++;
            if (setBits > 1) return false;
            n = n >> 1;
        }
        
        return setBits == 1;
    }
}

/** Bit Manipulation
 * Note that power of two (n) will be of form 0b100..0 so (n-1) should be 0b01111
 * Using this if n is pow of two, (n & n-1) should be 0
 * This property doesn't hold for any other n which isn't pow of 2
 * TC: O(1)
 * SC: O(1)
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
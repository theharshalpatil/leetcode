/** Brian Karnighan's Algorithm
 * TC: O(logn)
 * SC: O(1)
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            n &= (n-1);
            weight += 1;
        }
        return weight;
    }
}

/** Right shift N after '&' with one.
 * TC: O(logn)
 * SC: O(1)
 */
 public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            weight += n & 1;
            n >>= 1;
        }
        return weight;
    }
}
/**
 * To remove each digit, you need that many ones
 * eg.  3422
        1111
        1111
        1100
        0100
 * Thus minimum 4 nums
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (char a: n.toCharArray()) {
            max = Math.max(max, a - '0');
        }
        return max;
    }
}
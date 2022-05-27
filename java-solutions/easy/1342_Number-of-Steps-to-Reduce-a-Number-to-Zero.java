/**
 * Using bit operations we find if we've in unit's place
 * 1 -> subtract 1 from num; 0 -> divide by two a.k.a right shift num
 * TC: O(logn)
 * SC: O(1)
 */
class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            steps++;
            if ((num & 1) == 0) num >>= 1;
            else num -= 1;
        }
        return steps;
    }
}
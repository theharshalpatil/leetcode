/**
 * You can do iterative /3 untill you get 1. OR, convert n to base 3 and chck if there's only one '1'
 * TC: O(log3(n))
 * SC: O(log3(n))   -> size of converted string
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}

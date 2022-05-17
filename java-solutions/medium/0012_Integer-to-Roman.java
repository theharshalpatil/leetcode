/**
 * We use a lookup table approach as we remove the max available roman literal from given num and append it to answer.
 * Corner cases include preceding I, X, and C.
 * These can be dealt straightforward by adding these cases to the lookup table
 * TC: O(1) -> we iterate maximum for only a fixed number of times (13 - number of points in our lookup)
 * SC: O(1) -> We need to store only the lookup table which is (13*2 - constant)
 */
class Solution {
    public String intToRoman(int num) {
        String romans[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int values[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        
        int track = romans.length - 1;
        String ans = "";
        while (num > 0) {
            while (values[track] <= num) {
                ans += romans[track];
                num -= values[track];
            }
            track--;
        }
        
        return ans;
    }
}
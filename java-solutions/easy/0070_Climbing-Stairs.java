/** Fibonacci
 * Notice the DP array is fibonacci in reverse!
 * say for 5: [8, 5, 3, 2, 1, 1] (0 indexed from 0-5)
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public int climbStairs(int n) {
        int first = 1, second = 1;
        int temp = 0;
        
        for (int i = 0; i < n - 1; i++) {
            temp = first;
            first += second;
            second = temp;
        }
        
        return first;
    }
}
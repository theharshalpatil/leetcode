/**
 * Start from bottom up accumulating min sum path so far
 * TC: O(N^2)       -> Look at all the elements in triangle
 * SC: O(N)         -> N -> Height of triange
 */
class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1]; // init to 0's
        
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        
        return dp[0];
    }
}
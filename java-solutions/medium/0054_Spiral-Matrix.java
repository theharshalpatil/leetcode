/**
 * Traverse top row, dec top, right col, dec right, bot row, inc bot, left row, inc left
 * This will create a spiral. Stop when bot > top || left > right
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        int L = 0, R = matrix[0].length - 1;
        int T = 0, B = matrix.length - 1;
        
        while (true) {
            for (int i = L; i <= R; i++) ans.add(matrix[T][i]);
            if (B < ++T) break;
            for (int i = T; i <= B; i++) ans.add(matrix[i][R]);
            if (--R < L) break;
            for (int i = R; i >= L; i--) ans.add(matrix[B][i]);
            if (--B < T) break;
            for (int i = B; i >= T; i--) ans.add(matrix[i][L]);
            if (R < ++L) break;   
        }
        
        return ans;
    }
}
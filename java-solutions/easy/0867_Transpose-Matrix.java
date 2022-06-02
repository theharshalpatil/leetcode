/**
 * (i, j) index shall become (j, i) in T-matrix
 * TC: O(M*N)
 * SC: O(1)     -> not considering ans[][]
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
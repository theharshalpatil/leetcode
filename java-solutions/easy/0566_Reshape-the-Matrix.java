/**
 * Traverse through input mat, maintain row/col pointers for target
 * With each element in mat, col++. If no more cols, row++ and col=0
 * TC: O(M*N)   -> number of elements in input matrix
 * SC: O(1)     -> Not considering the result matrix
 */
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        
        // Special case when reshaping isn't possible
        if (m*n != r*c) return mat;
        
        // We add on col at a time, inc row if col exhausts and resets
        int[][] res = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[row][col++] = mat[i][j];
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        
        return res;
    }
}
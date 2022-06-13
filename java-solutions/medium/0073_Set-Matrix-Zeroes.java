/**
 * First, note which rows/cols are to be converted to zeros
 * Set a place to zero if it falls in one of the above row/col
 * TC: O(M * N)
 * SC: O(M + N)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean[] rowsToZero = new boolean[rows];
        boolean[] colsToZero = new boolean[cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowsToZero[i] = true;
                    colsToZero[j] = true;
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowsToZero[i] || colsToZero[j])
                    matrix[i][j] = 0;
            }
        }
    }
}

/**
 * Same as above but we use top row and first col as our extra space
 * We need one extra variable as mat[0][0] will be overlapped
 * TC: O(M * N)
 * SC: O(1)
 * NOTE: Interestingly, this solution took 3ms & 54.5MiB
 * viz. 2ms * 0.1MiB greater than prev solution
 */
 class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean isFirstRowZero = false;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i > 0) matrix[i][0] = 0;
                    else isFirstRowZero = true;
                }
            }
        }
        
        // Setting all elements except 1st row/col
        // as we don't want to loose data for which to make zeros
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        // Complete 1st row/col
        if (matrix[0][0] == 0)
            for (int i = 0; i < rows; i++) matrix[i][0] = 0;
        if (isFirstRowZero)
            for (int i = 0; i < cols; i++) matrix[0][i] = 0;
    }
}
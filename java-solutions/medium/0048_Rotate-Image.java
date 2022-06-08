/** Rotation by 90-deg is basically Transpose and reverse the columns
 * TC: O(N^2)
 * SC: O(1)
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        
        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reverse array on ever row
        for (int i = 0; i < n; i++) {
            int l = -1, r = n;
            while (++l <= --r) {
                temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
        }
    }
}

/** Good ol' generalized rotation (Takes exact time ans space as above on leetcode)
 * TC: O(N^2)
 * SC: O(1)
 */
class Solution {
    public void rotate(int[][] mat) {
        int L = 0, R = mat.length - 1;
        int temp = 0, T = L , B = R;
        while (L < R) {
            T = L; B = R;
            for (int i = 0; i < R-L; i++) {
                temp = mat[T][L + i];
                mat[T][L + i] = mat[B - i][L];
                mat[B - i][L] = mat[B][R - i];
                mat[B][R - i] = mat[T + i][R];
                mat[T + i][R] = temp;
            }
            L++; R--;
        }
    }
}
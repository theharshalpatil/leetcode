/**
 * Start searching from top-right like in a BST
 * TC: O(N + M) -> N is rows, M is cols
 * SC: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1;
        
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) i++;
            else j--;
        }
        
        return false;
    }
}
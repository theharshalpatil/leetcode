/** Binary Search
 * We perform a binary search as if the matrix was a 1D array.
 * But map the index of 1D array to 2D matrix we do the following:
 *  1. int divide idx by width to get the row
 *  2. idx % width will give the col
 * TC: O(logn)
 * SC: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length, w = matrix[0].length; // assured 0th idx
        int l = 0, r = h*w - 1, mid = -1;
        
        while (l <= r) {
            mid = l + (r-l)/2;
            if (matrix[mid/w][mid%w] == target) return true;
            if (matrix[mid/w][mid%w] > target) r = mid - 1;
            else l = mid + 1;
        }
        
        return false;
    }
}

/** Binary Search Tree approach
 * we can look at the matrix as a BST where top node is top-right corner.
 * All the elemnts shall be greater than element to the left and element on bottom
 * TC: O(n) -> There can just be one row
 * SC: O(1)
 */
 class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) row++;
            else col--;
        }
        
        return false;
    }
}
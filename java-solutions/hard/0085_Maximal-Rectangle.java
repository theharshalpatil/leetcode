/**
 * For each row, we can create a cumulative histogram and find the max area rectangle
 * This is done as done in #0084
 * TC: O(M * 2N)    -> M rows, N cols
 * SC: O(N)         -> Stack for histogram of len N
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] hist = new int[cols];
        int ans = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '1') hist[c]++;
                else hist[c] = 0;
            }
            ans = Math.max(ans, maxRectangleInHistogram(hist));
        }
        
        return ans;
    }
    
    public int maxRectangleInHistogram(int[] heights) {
        int maxArea = 0;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
                Pair<Integer, Integer> h = stack.pop();
                maxArea = Math.max(maxArea, h.getValue() * (i - h.getKey()));
                start = h.getKey();
            }
            stack.add(new Pair<Integer, Integer>(start, heights[i]));
        }
        
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> h = stack.pop();
            maxArea = Math.max(maxArea, h.getValue() * (heights.length - h.getKey()));
        }
        
        return maxArea;
    }
}
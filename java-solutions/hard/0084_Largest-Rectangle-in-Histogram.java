/**
 * Use a monotonically increasing stack to track start idx and max height till now.
 * If a height is encountered which is smaller than stack.peek(),
 * we compute for peek and pop till height is <= to encountered height - push back start idx of this height accordingy
 * In the end, we pop all heights in stack to compute maxArea
 * TC: O(N)
 * SC: O(N)
 *
 * OTHER WAYS: Brute Force, compute height for all combos and return max O(N^2) TC & O(1) SC
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
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
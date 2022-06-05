/**
 * We use a stack to store monotonically decreasing numbers so far (max of 3 on top of stack)
 * Along with this we also store the min number that came until the above number (min of 3)
 * If we encounter a number now that is greater than number on top of stack - return true!
 * TC: O(N) -> Worst case we put all elements in stack and then pop them
 * SC: O(N) -> Worst case we'll have all elements in the stack
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        
        Stack<Pair<Integer, Integer>> s = new Stack<>();
        int minL = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            while (!s.isEmpty() && nums[i] >= s.peek().getKey()) {
                s.pop();
            }
            if (!s.isEmpty() && nums[i] > s.peek().getValue())
                return true;
            s.push(new Pair(nums[i], minL));
            minL = Math.min(minL, nums[i]);
        }
        
        return false;
    }
}
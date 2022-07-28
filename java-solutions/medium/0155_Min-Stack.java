/** Store the min so-far along with value in the stack
 * TC: O(1) for every function
 * SC: O(2N)
 */
class MinStack {
    Stack<Pair<Integer, Integer>> stack;
    int globalMin;

    public MinStack() {
        stack = new Stack<>();
        globalMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        globalMin = Math.min(globalMin, val);
        stack.push(new Pair(val, globalMin));
    }
    
    public void pop() {
        stack.pop();
        if (stack.size() == 0) globalMin = Integer.MAX_VALUE;
        else globalMin = stack.peek().getValue();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
    }
}
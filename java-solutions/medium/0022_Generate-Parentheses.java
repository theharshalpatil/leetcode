/**
 * Using Queue method to generate all possible combinations
 * Storing in answer List only if the parentheses are valid.
 * TC: O(2^N * N) -> 2^N for generation of strings, N for checking validity
 * SC: O(2^N + N) -> 2^N for Queue, N for Stack
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        
        if (n == 1) {
            ans.add("()");
            return ans;
        }
        
        Queue<String> q = new LinkedList<>();
        q.add("");
        
        while (!q.isEmpty()) {
            String curr = q.remove();
            if (curr.length() == n*2) {
                if (isValid(curr)) ans.add(curr);
            } else if (curr.length() == n*2 - 1) {
                q.add(curr + ")");
            } else if (curr.length() == 0) {
                q.add("(");
            } else {
                q.add(curr + "(");
                q.add(curr + ")");
            }
        }
        
        return ans;
    }
    
    boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int validity = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') st.push(c);
            else if (st.isEmpty()) return false;
            else st.pop();
        }
        return st.isEmpty();
    }
}

/** Beautiful Backtracking
 * TC: O(2^n) -> two possibilities ['(', ')'] over N pair times.
 * SC: O(1)
 */
 class Solution {
    List<String> ans = new ArrayList<>();
    int max = 0;
    
    public List<String> generateParenthesis(int n) {
        max = n;
        backtrack(ans, "", 0, 0);
        return ans;
    }
    
    public void backtrack(List<String> arr, String curr, int open, int close) {
        if (curr.length() == max*2) {
            arr.add(curr);
            return;
        }
        // open only if we've not exhausted open parentheses
        if (open < max) backtrack(arr, curr + "(", open + 1, close);
        // close only if we've a corresponding open parenthesis present
        if (close < open) backtrack(arr, curr + ")", open, close + 1);
    }
}
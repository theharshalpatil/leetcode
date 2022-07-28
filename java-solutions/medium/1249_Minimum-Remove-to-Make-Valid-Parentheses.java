/** Use stack to figure out indices that need to be deleted
 * TC: O(N)
 * SC: O(N)
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' && stack.size() > 0 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                continue;
            }
            if (ch == '(' || ch == ')') stack.push(i);
        }
        
        StringBuilder ans = new StringBuilder(s);
        int curr = 0;
        while (stack.size() > 0) {
            curr = stack.pop();
            ans.deleteCharAt(curr);
        }
        
        return ans.toString();
    }
}
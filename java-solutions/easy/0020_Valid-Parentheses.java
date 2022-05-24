/** Maintain a stack to store opening braces
 * Return when brackes mismatch or stack is empty
 * TC: O(N) -> looks at each char in string once
 * SC: O(N) -> Stack can be full if all are opening braces
 */
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put('}', '{');
        pair.put(')', '(');
        pair.put(']', '[');
        
        Stack<Character> st = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (pair.containsValue(c)) st.push(c);
            else {
                if (st.isEmpty() || pair.get(c)!=st.pop()) return false;
            }
        }
        
        return st.isEmpty();
    }
}

/** What if we don't want to use Stack?
 *  We then use pointers to find the next 'top' of imaginary stack
 * TC: O(N^2) -> one loop for iterating through string, other to find top
 * SC: O(1) -> No auxiliary space!
 */
 class Solution {
    Map<Character, Character> pair = new HashMap<>();
    
    public boolean isValid(String s) {
        pair.put('}', '{');
        pair.put(')', '(');
        pair.put(']', '[');
        
        int top = -1;   // meaning no element in stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pair.containsValue(c)) top = i;
            else {
                if (top == -1 || pair.get(c)!=s.charAt(top)) return false;
                else { // found match shift top
                    top = getTop(s, top - 1); // String and the index till we need to find top
                }
            }
        }
        
        return top == -1;
    }
    
    int getTop(String s, int idx) {
        int right = 0;
        while (idx >= 0) {
            char ch = s.charAt(idx);
            if (pair.containsKey(ch)) right++; // is closing bracket
            else right--;
            
            if (right < 0) return idx;
            idx--;
        }
        return -1;  
    }
}
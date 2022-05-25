/**
 * Uses a recurcive backtrack function to build a string.
 * At each index, for every possible character, backtrack is called for remaining digits
 * TC: O(N * 4^N) -> N is len(digits)
 * SC: O(N)
 */
class Solution {
    Map<Character, String> dial = Map.of(
    '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
    '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    
    private List<String> ans = new ArrayList<>();
    private String phoneDigits;
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        
        return ans;
    }
    
    void backtrack(int idx, StringBuilder curr) {
        if (curr.length() == phoneDigits.length()) {
            ans.add(curr.toString());
            return;
        }
        
        for (char c: dial.get(phoneDigits.charAt(idx)).toCharArray()) {
            curr.append(c);
            backtrack(idx+1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        
    }
}

/** Another solution is to leverage FIFO nature of queues!
 */
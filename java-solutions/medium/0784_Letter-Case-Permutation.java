/** Backtracking
 * TC: O(2^len(s))   -> All alphabets, two branches from each choice
 * SC: O(len(s))     -> Size of recurssion stack
 */
class Solution {
    List<String> ans;
    String given;
    
    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        given = s;
        permute(sb);
        return ans;
    }
    
    public void permute(StringBuilder sb) {
        if (sb.length() == given.length()) {
            ans.add(sb.toString());
            return;
        }
        
        char ch = given.charAt(sb.length());
        if (Character.isDigit(ch)) {
            sb.append(ch);
            permute(sb);
        } else {
            sb.append(Character.toLowerCase(ch));
            permute(sb);
            sb.setCharAt(sb.length() - 1, Character.toUpperCase(ch));
            permute(sb);
        }
        // don't forget to unset coz sb is a object reference!
        sb.setLength(sb.length() - 1);
    }
}
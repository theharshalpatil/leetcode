/**
 * TC: O(N)     -> N = len(S)
 * SC: O(1)     -> Roman to Int mapping takes const space
 */
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (values.get(s.charAt(i)) < values.get(s.charAt(i+1)))
                ans -= values.get(s.charAt(i));
            else
                ans += values.get(s.charAt(i));
        }
        
        return ans + values.get(s.charAt(s.length()-1));
    }
}
/**
 * TC: O(N)
 * SC: O(N)
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        
        Map<Character, String> seen = new HashMap<>();
        char pchar = pattern.charAt(0);
        
        for (int i = 0; i < pattern.length(); i++) {
            pchar = pattern.charAt(i);
            
            // If the key isn't seen but word exists - invalid
            if (!seen.containsKey(pchar) && seen.containsValue(words[i]))
                return false;
            
            // If the key is seen but corresponding word is different - invalid
            if (seen.containsKey(pchar) && !words[i].equals(seen.get(pchar)))
                return false;
            
            seen.put(pchar, words[i]);
        }
        
        return true;
    }
}
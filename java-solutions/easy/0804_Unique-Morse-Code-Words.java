/**
 * Use HashSet to store unique tranforms
 * TC: O(N)
 * SC: O(N)
 */
class Solution {
    private String[] morse = {".-","-...","-.-.","-..",".","..-.","--.",
                              "....","..",".---","-.-",".-..","--","-.",
                              "---",".--.","--.-",".-.","...","-","..-",
                              "...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transforms = new HashSet<>();
        for (String word: words)
            transforms.add(transform(word));
        return transforms.size();
    }
    
    private String transform(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c: word.toCharArray()) {
            sb.append(morse[c - 'a']);
        }
        return sb.toString();
    }
}

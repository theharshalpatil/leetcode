/** Sliding window
 * We know that a valid substring is always of size len(words[0])*len(words)
 * Make a sliding window out of it and check for each substring by extracting len(words[0]) length words
 * This is done by checking the count of encountered words. if any one count goes to 0 but further word is encountered,
 *     then, the substring must be invalid. Add all valid starting indices to ans and return
 * TC: O(nab - (ab)^2)  -> O(a) to create backup map; O(a) iterations in isValid(); check this over (N) times (if len(words[0]) == 1)
 *                      -> O((n - a.b).(a.b)) ~ O(nab - (ab)^2)
 * SC: O(a + b)         -> O(a) for the wordCount; to store 'sub' in isValid() O(b). if b is small we can say SC = O(a)
 */
class Solution {
    private HashMap<String, Integer> wordCount = new HashMap<>();
    private int wordLength;
    private int substringSize;
    private int k;
    
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;
        
        // get wordCount
        for (String word: words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (isValid(i, s)) {
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int i, String s) {
        // create a backup
        HashMap<String, Integer> remaining = new HashMap<>(wordCount);
        int wordsUsed = 0;
        
        // check for match in words with a word of len wordLength
        for (int j = i; j < i + substringSize; j += wordLength) {
            String sub = s.substring(j, j + wordLength);
            if (remaining.getOrDefault(sub, 0) != 0) {
                remaining.put(sub, remaining.get(sub) - 1);
                wordsUsed++;
            } else {
                break;
            }
        }
        
        return wordsUsed == k;
    }
}

/** Optimized Sliding window
 * TC: O(a + n*b)
 * SC: O(a + b)
 * NOTE: Explaination - https://leetcode.com/problems/substring-with-concatenation-of-all-words/solution/
 */
class Solution {
    private HashMap<String, Integer> wordCount = new HashMap<>();
    private int n;
    private int wordLength;
    private int substringSize;
    private int k;
    
    public List<Integer> findSubstring(String s, String[] words) {
        n = s.length();
        k = words.length; // number of words
        wordLength = words[0].length();
        substringSize = wordLength * k;
        
        for (String word: words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) {
            slidingWindow(i, s, ans);
        }
        return ans;
    }
    
    private void slidingWindow(int left, String s, List<Integer> ans) {
        HashMap<String, Integer> wordsFound = new HashMap<>();
        int wordsUsed = 0;
        boolean excessWord = false;
        
        // same iteration pattern as prev approach - iterate wordLength at a time
        // at each iteration we focus on one word
        for (int right = left; right <= n - wordLength; right += wordLength) {
            String sub = s.substring(right, right + wordLength);
            if (!wordCount.containsKey(sub)) {
                // mismatched word - reset window
                wordsFound.clear();
                wordsUsed = 0;
                excessWord = false;
                left = right + wordLength;
            } else {
                // reached max window size or have an excess word
                while (right - left == substringSize || excessWord) {
                    String leftmostWord = s.substring(left, left + wordLength);
                    left += wordLength;
                    wordsFound.put(leftmostWord, wordsFound.getOrDefault(leftmostWord, 0) - 1);
                    if (wordsFound.get(leftmostWord) >= wordCount.get(leftmostWord)) {
                        excessWord = false; // this word was an excess word
                    } else {
                        wordsUsed --;
                    }
                }
                
                // keep track of how may times this word occurs in the window
                wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
                if (wordsFound.get(sub) <= wordCount.get(sub)) {
                    wordsUsed++;
                } else {
                    excessWord = true; // found too many instances already
                }
                
                if (wordsUsed == k && !excessWord) {
                    // found a valid substring
                    ans.add(left);
                }
            }
            
        }
    }
}
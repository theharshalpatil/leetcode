/**
 * We try to convert the problem to a BFS to find the min steps required
 * Depth refers to the number of changes we've made to our start word.
 * Maintain a queue that includes valid changed words for a given depth and run search
 * If the word is found return the current depth (steps)
 * TC: O(M^2 * N)   -> M = len(dequeued word), N = len(wordlist)
 * SC: O(M * N)     -> M = number of chars in our string, N = len(wordList)
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashSet<String> seen = new HashSet<>();
        seen.add(beginWord);
        int steps = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return steps;

                for (int i = 0; i < curr.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char[] arr = curr.toCharArray();
                        arr[i] = j;
                        String str = new String(arr);

                        if (words.contains(str) && !seen.contains(str)) {
                            queue.add(str);
                            seen.add(str);
                        }
                    }
                }
            }
            
            steps++;
        }
        
        return 0;
    }
}
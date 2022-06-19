/**
 * We design a Trie and insert word along with max 3 suggestions
 * To maintain lexicographical order, we sort the String[] first
 * TC: O(NlogN + N * M + K)     -> Insert N string of M len into Trie + search of K len word
 * SC: O(26 ^ len(longest word)) -> Size of Trie
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        
        Trie trie = new Trie();
        for (String s: products)
            trie.insert(s);
        
        int i = 0;
        while (i < searchWord.length()) {
            trie = trie.t[searchWord.charAt(i) - 'a'];
            if (trie == null) break;
            ans.add(trie.suggestions);
            i++;
        }
        while (i < searchWord.length()) {
            ans.add(new ArrayList<String>());
            i++;
        }
        
        return ans;
    }
    
    class Trie {
        List<String> suggestions;
        Trie[] t;
        
        Trie() {
            suggestions = new ArrayList<>();
            t = new Trie[26];
        }
        
        // O(N)
        public void insert(String s) {
            Trie trie = this;
            for (char c: s.toCharArray()) {
                if (trie.t[c - 'a'] == null)
                    trie.t[c - 'a'] = new Trie();
                trie = trie.t[c - 'a'];
                if (trie.suggestions.size() < 3)
                    trie.suggestions.add(s);
            }
        }
    }
}
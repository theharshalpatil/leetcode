/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
/**
 * Maintain 2 Trie's for suffix and prefix search. Find all eligible idx's for suff & pref
 * Return the highest common idx for both the obtained eligible idx.
 * TC: O(N*K + Q*(K + N))   -> Q = number of queries
 * SC: O(N * MaxLen(word))
 * On Lettcode: Time Limit Exceeded
 */
class WordFilter {
    Trie prefix, suffix;

    // TC: O(N * maxLen(word)) = O(N * K)
    public WordFilter(String[] words) {
        prefix = new Trie();
        suffix = new Trie();
        
        for (int i = 0; i < words.length; i++) {
            prefix.insert(words[i], i);
            suffix.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
    }
    
    // TC: MaxLen(pref, suff) + N = O(K + N)
    public int f(String pref, String suff) {
        List<Integer> pidx = prefix.startsWith(pref);   // MaxLen(pref)
        List<Integer> sidx = suffix.startsWith(new StringBuilder(suff).reverse().toString());
        
        int i = pidx.size() - 1, j = sidx.size() - 1;
        while (i >= 0 && j >= 0) { // N
            if (pidx.get(i).equals(sidx.get(j))) return pidx.get(i);
            else if (pidx.get(i) > sidx.get(j)) i--;
            else j--;
        }
        
        return -1;
    }
    
    class Trie {
        Trie[] t;
        List<Integer> idx;
        
        Trie() {
            t = new Trie[26];
            idx = new ArrayList<>();
        }
        
        // insert
        public void insert(String word, int i) {
            Trie root = this;
            for (char c: word.toCharArray()) {
                if (root.t[c - 'a'] == null) {
                    root.t[c - 'a'] = new Trie();
                }
                root = root.t[c - 'a'];
                root.idx.add(i);
            }
        }
        
        // startsWith
        public List<Integer> startsWith(String pref) {
            Trie root = this;
            for (char c: pref.toCharArray()) {
                if (root.t[c - 'a'] == null)
                    return new ArrayList<Integer>();
                root = root.t[c - 'a'];
            }
            return root.idx;
        }
    }
}

/**
 * We use a suff#word key that we insert in a single Trie
 * TC: O(NK^2 + QK) -> N=number of words, K=maxLen(word), Q=number of queries
 * SC: O(NK^2)      -> size of trie
 */
 class WordFilter {
    TrieNode trie;
    public WordFilter(String[] words) {
        trie = new TrieNode();
        for (int weight = 0; weight < words.length; ++weight) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); ++i) {
                TrieNode cur = trie;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; ++j) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null)
                        cur.children[k] = new TrieNode();
                    cur = cur.children[k];
                    cur.weight = weight;
                }
            }
        }
    }
    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        for (char letter: (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[letter - 'a'] == null) return -1;
            cur = cur.children[letter - 'a'];
        }
        return cur.weight;
    }
}

class TrieNode {
    TrieNode[] children;
    int weight;
    public TrieNode() {
        children = new TrieNode[27];
        weight = 0;
    }
}
/**
 * We maintain a map where we store all the strings with same sorted value
 * in a key as a List. The values of this map can then be put in another list to get answer
 * TC: O(N * M * logM)      -> N is no of strings (check once N), M size of each string (sorting MlogM)
 * SC: O(N)                 -> To maintain Map
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> seen = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for (String s: strs) {
            // Sort the string
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            
            if (!seen.containsKey(sorted))
                seen.put(new String(sorted), new ArrayList<>());
            
            seen.get(sorted).add(s);
        }
        
        for (Map.Entry<String, List<String>> entry: seen.entrySet())
            ans.add(entry.getValue());
        
        return ans;
    }
}

/**
 * We maintain a map where we store all the strings with count of chars in string (no sorting required)
 * in a key as a List. The values of this map can then be put in another list to get answer
 * TC: O(N * M)      -> N is no of strings (check once N), M size of each string (counting is O(1))
 * SC: O(N)          -> To maintain Map
 * NOTE: Interestingly this runs slower than prev on leetcode
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> seen = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for (String s: strs) {
            int[] count = new int[26];
            for (char c: s.toCharArray())
                count[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) sb.append(count[i] + "" + (char)('a' + i));
            }
            String key = sb.toString();
            
            if (!seen.containsKey(key))
                seen.put(new String(key), new ArrayList<>());
            
            seen.get(key).add(s);
        }
        
        System.out.println(seen);
        
        for (Map.Entry<String, List<String>> entry: seen.entrySet())
            ans.add(entry.getValue());
        
        return ans;
    }
}
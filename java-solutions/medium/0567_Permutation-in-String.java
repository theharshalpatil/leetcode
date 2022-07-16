/**
 * Sliding window of size len(s1) and compare frequencies of occuring words with each slide
 * TC: O(N + 26*(M - N))    -> N = len(s1), M = len(s2)
 * SC: O(1)                 -> only 2 arrays of fixed len (26)
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        
        // create a default window of size of s1
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        
        // Slide the s1-sized window on s2 and check for match
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map)) return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        
        return matches(s1map, s2map);
    }
    
    public boolean matches(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++)
            if (s1[i] != s2[i]) return false;
        return true;
    }
}

/**
 * Same sliding-window as above, but instead of checking all the alphabet frequencies,
 * we maintain count of matching alphabet freqs and update only those freqs which are added/removed from window
 * if matiching alpha freq's count reaches 26 = all alphabet freqs match (thus palindrome) return true
 * TC: O(len(s2))
 * SC: O(1)
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        
        // create a default window of size of s1
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        
        // Keep the count of how many alphabet freq matches
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i]) count++;
        
        // Slide the s1-sized window on s2 and check if all aphabet freq matches
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (count == 26) return true;
                                                             
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            
            s2map[r]++;
            if (s2map[r] == s1map[r]) count++;
            else if (s2map[r] == s1map[r] + 1) count--;
            s2map[l]--;
            if (s2map[l] == s1map[l]) count++;
            else if (s2map[l] == s1map[l] - 1) count--;
        }
        
        return count == 26;
    }
}
/**
 * Sorting and maintaining the max allowed frequencies till now.
 * TC: O(N + KlogK)     -> N to build freq array. KlogK to sort (K = 26). calculating ans is O(1)
 * SC: O(K)             -> to store freq of alphabet - not dependent on string size. (K = 26)
 */
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) freq[c - 'a']++;
        
        // since we don't care which char we wanna delete,
        // we could just sort freq to get maximums to the end
        Arrays.sort(freq);
        
        // begin from the end and count the deletions
        int ans = 0;
        int maxFreqAllowed = s.length();
        for (int i = 25; i >= 0 && freq[i] > 0; i--) {
            if (freq[i] > maxFreqAllowed) {
                ans += freq[i] - maxFreqAllowed;
                freq[i] = maxFreqAllowed;
            }
            maxFreqAllowed = Math.max(0, freq[i] - 1);
        }
        
        return ans;
    }
}
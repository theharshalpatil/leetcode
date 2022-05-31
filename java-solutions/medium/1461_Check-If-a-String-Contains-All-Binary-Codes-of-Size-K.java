/** Brute Force
 * Check for all binary numbers from [0...2^k-1] of len=k
 * if any of them isn't contained in 's', return false
 * TC: O(2^k * N)   -> N=len(s)
 * SC: O(1)
 */
class Solution {
    public boolean hasAllCodes(String s, int k) {
        for (int i = 0; i < Math.pow(2, k); i++) {
            String check = String.format("%1$" + k + "s", Integer.toBinaryString(i)).replace(' ', '0');
            if (!s.contains(check)) return false;
        }
        return true;
    }
}

/** Sliding Window
 * Memorize in a bool[] of size 2^k-1 if a binary string is seen in the window
 * Check if all in bool[] are true, if not, return false
 * TC: O(N-k)   -> N=len(S)
 * SC: O(2^k)   -> To store all the seen number status
 */
 class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (k >= s.length()) return false;
        boolean[] seen = new boolean[(int)Math.pow(2, k)];
        for (int i = 0; i <= s.length() - k; i++) {
            int check = Integer.parseInt(s.substring(i, i+k), 2);
            seen[check] = true;
        }
        for (boolean c: seen) {
            if (!c) return false;
        }
        return true;
    }
}

/** Set of Substrings of len=k
 * Add all the k len substrings in a Set
 * if all the k-sized binary strings are present, size of Set should be 2^k
 * TC: O(N)
 * SC: O(2^k)   -> This is worse than bool[] as these are Strings
 */
 class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i+k));
        }
        return (seen.size() == (1 << k));
    }
}
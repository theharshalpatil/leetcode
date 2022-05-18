/**
 * 1. Find the length of shortest string
 * 2. Find all the shortest strings
 * 3. Check each shortest string (checker strings) if it is a prefix for all
 * 4. Return the longest checker string
 * TC: O(NM) -> all strings same
 * SC: O(NM) -> all strings same len
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int shortestLen = Integer.MAX_VALUE;
        String shortestStr = "";
        
        // Find the length of shortest string
        for (String str: strs) {
            if (str.length() < shortestLen) shortestLen = str.length();
        }
        
        // Collect all strings which are shortest
        List<String> checkers = new ArrayList<String>();
        for (String str: strs) {
            if (str.length() == shortestLen) checkers.add(new String(str));
        }
        
        // Bring down checkers to the longest common prefix
        for (int i = 0; i < checkers.size(); i++) {
            String check = checkers.get(i);
            for (String str: strs) {
                int p1 = 0;
                while (p1 < check.length() && check.charAt(p1) == str.charAt(p1)) {
                    p1++;
                }
                if (p1 < check.length()) {
                    checkers.set(i, check.substring(0, p1));
                    check = checkers.get(i);
                }
                if (check.length() == 0) continue;
            }
        }
        
        // Pick the longest checker as "Longest Common Prefix"
        int longestPrefixLen = 0;
        String longestPrefix = "";
        for (String str: checkers) {
            if (str.length() > longestPrefixLen) {
                longestPrefixLen = str.length();
                longestPrefix = str;
            }
        }
        
        return longestPrefix;
    }
}

/**
 * But, What! Do we really need to pull out all the shortest strings?
 *    One shortest sring should suffice as it shall consequently be checked with all other shortest strings!
 * If a common prefix do not emerge, it anyway tells us that such a prefix does not exist.
 * If a common prefix emerges, we shall anyway continue to check prefixes for other remaining strings
 * TC: O(MN) -> M is len of string, N is size of String array
 * SC: O(1) -> No extra space required apart from final answer and pointers
 */
 class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // Find the length of shortest string
        int shortestLen = Integer.MAX_VALUE;
        for (String str: strs) {
            if (str.length() < shortestLen) shortestLen = str.length();
        }
        
        // Pick first occuring shortest string
        String checker = null;
        for (String str: strs) {
            if (str.length() == shortestLen) {
                checker = new String(str);
                break;
            }
        }
        
        // Bring down checker to the longest common prefix
        for (String str: strs) {
            int p1 = 0;
            while (p1 < checker.length() && checker.charAt(p1) == str.charAt(p1)) {
                p1++;
            }
            if (p1 < checker.length()) checker = checker.substring(0, p1);
            if (checker.length() == 0) break;
        }
        
        // return checker as "Longest Common Prefix"
        return checker;
    }
}
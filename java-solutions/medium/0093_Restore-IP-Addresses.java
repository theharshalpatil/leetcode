/**
 * Backtracking - consider/ignore '.' at each index
 * TC: O(2^N) -> N = len of string
 * SC: O(N)   -> Recursion stack size
 */
class Solution {
    List<String> ans;
    
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        backtrack(s, 1, 0);
        return ans;
    }
    
    public void backtrack(String s, int i, int dotCount) {
        if (dotCount == 3 && isValidIp(s)) {
            ans.add(s);
            return;
        }
        if (i >= s.length() || dotCount > 3) return;
        
        backtrack(s.substring(0, i) + "." + s.substring(i), i + 2, dotCount + 1);
        backtrack(s, i + 1, dotCount);
    }
    
    public boolean isValidIp(String s) {
        // Be cautious split() takes in a regex
        String[] units = s.split("[.]");
        for (String unit: units) {
            if (unit.length() > 3) return false;
            if (unit.charAt(0) == '0' && unit.length() > 1) return false;
            if (Integer.parseInt(unit) > 255) return false;
        }
        return true;
    }
}

/**
 * With a bunch of optimizations!
 * TC: O(3^4)   -> 3 choices max depth 4
 * SC: O(4)     -> depth of DT
 */
 class Solution {
    List<String> ans;
    
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        // valid IP will not have more than 12 digits
        if (s.length() > 12) return ans;
        backtrack(s, 1, 0);
        return ans;
    }
    
    public void backtrack(String s, int i, int dotCount) {
        if (dotCount == 3 && isValidIp(s)) {
            ans.add(s);
            return;
        }
        if (dotCount > 3) return;
        
        // consider only next 3 digits for next number!
        for (int j = i; j < Math.min(i+3, s.length()); j++) {
            backtrack(s.substring(0,j) + "." + s.substring(j), j+2, dotCount+1);
        }
    }
    
    public boolean isValidIp(String s) {
        // Be cautious split() takes in a regex
        String[] units = s.split("[.]");
        for (String unit: units) {
            if (unit.length() > 3) return false;
            if (unit.charAt(0) == '0' && unit.length() > 1) return false;
            if (Integer.parseInt(unit) > 255) return false;
        }
        return true;
    }
}
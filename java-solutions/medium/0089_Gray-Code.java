/**
 * Recursive
 * TC: O(2^N)   -> number of elements
 * SC: O(N)     -> Size of recursion tree
 */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        
        if (n == 0) return ans;
        
        ans.add(1);
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            curr *= 2;
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(curr + ans.get(j));
            }
        }
        
        return ans;
    }
}

/** Iterative
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int num = 1<<n; // total numbers
        for(int i = 0; i < num; i++) {
            res.add((i>>1)^i);
        }
        return res;
    }
}
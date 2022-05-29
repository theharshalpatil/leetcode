/**
 * Start by a default [1] and then build each next List with help of old List
 * TC: O(N^2)   -> Number of steps would be (N*(N+1)/2)
 * SC: O(N)     -> To store extra old array which will be max (N-1) in length
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        
        List<Integer> old = ans.get(0);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(old.get(j-1) + old.get(j));
            }
            curr.add(1);
            ans.add(curr);
            old = curr;
        }
        return ans;
    }
}
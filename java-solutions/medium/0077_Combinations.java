/** Backtracking
 * Do a DFS over 1-n ans save in ans if we secured k numbers
 * TC: O(K * N^K)
 * SC: O(K)
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        backtrack(0, n, k, curr);
        return ans;
    }
    
    private void backtrack(int idx, int n, int k, List<Integer> curr) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i < n; i++) {
            curr.add(i + 1);
            backtrack(i + 1, n, k, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
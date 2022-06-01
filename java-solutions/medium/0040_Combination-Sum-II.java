/** Backtracking
 * We sort the input array. Then either/not consider an element.
 * To avoid duplicate traversals, once we consider an element, we never consider it again (as inp list has dups)
 * To not consider again, we increment out curr candidate pointer untill we land on a different element
 * TC: O(2^N)   -> Each of N elementns can either be considered/not. Possible N distinct elements
 * SC: O(N)     -> temp combination holder can take upto all candidates
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] arr = null;
    int prev = -1;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        arr = candidates;
        backtrack(0, target, new ArrayList<>());
        return ans;
    }
    
    private void backtrack(int idx, int target, List<Integer> temp) {
        if (target == 0) ans.add(new ArrayList(temp));
        if (target <= 0) return;
        
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == prev) continue;
            temp.add(arr[i]);
            backtrack(i + 1, target - arr[i], temp);
            temp.remove(new Integer(arr[i]));
            prev = arr[i];
        }
    }
}
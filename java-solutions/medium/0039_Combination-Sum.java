/**
 * Using backtracing we either/not select a number and check for:
 *  1. if target is reached, we add all the numbers till now to ans as a List
 *  2. if target is yet to be reached, we backtrack next number
 * TC: O(N * 2^N)   -> N=len(candidates). one FOR and other recursion
 * SC: O(N)         -> N for temp list. ans isn't considered
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] arr;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        arr = candidates;
        
        List<Integer> temp = new ArrayList<>();
        
        backtrack(target, 0, temp);
        
        return ans;
    }
    
    private void backtrack(int target, int idx, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList(temp));
            return;
        }
        
        for (int i = idx; i < arr.length; i++) {
            if (target - arr[i] >= 0) {
                temp.add(arr[i]);
                backtrack(target - arr[i], i, temp);
                temp.remove(new Integer(arr[i]));
            }
        }
    }
}
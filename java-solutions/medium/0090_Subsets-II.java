/** Backtracking
 * While picking a number, we've two choices.
 * 1. Pick the number and build a subtree that includes that number
 * 2. Don't pick the number and build a subtree that never includes that number
 * TC: O(N * 2^N)
 * SC: O(N)
 */
class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>());
        
        return ans;
    }
    
    public void findSubsets(int i, int[] nums, List<Integer> set) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(set));
            return;
        }
        
        // All subsets that include nums[i]
        set.add(nums[i]);
        findSubsets(i + 1, nums, set);
        set.remove(set.size() - 1);
        
        // Add subsets that don't include nums[i]
        while (i + 1 < nums.length && nums[i] == nums[i+1]) i++;
        findSubsets(i + 1, nums, set);
    }
}
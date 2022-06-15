/** Recurssion - DFS
 * We basically find all subsets of length 'k' where k in (0 ... len(nums))
 * TC: O(N * 2^N)  -> as k from (0...N) is of order N^2
 * SC: O(N)     -> To store intermidiate subset
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        
        List<Integer> set = new ArrayList<>();
        // k as len of subset
        for (int k = 1; k <= nums.length; k++)
            generateSubsets(nums, 0, k, set);
        
        return ans;
    }
    
    private void generateSubsets(int[] nums, int curr, int k, List<Integer> set) {
        if (set.size() == k) {
            ans.add(new ArrayList<>(set));
            return;
        }
        
        // Sweet little optimization to not check unnecessary values
        int upperLimit = Math.min(curr + nums.length - k, nums.length - 1);
        for (int i = curr; i <= upperLimit; i++) {
            set.add(nums[i]);
            generateSubsets(nums, i + 1, k, set);
            set.remove(set.size() - 1);
        }
    }
}
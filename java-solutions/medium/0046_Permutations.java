/**
 * We take each element in position 'i' and permute on the remaining array
 * In such a way we'll create a tree whose leaves are needed permutations
 * TC: O(N^2)       -> We take each num on a given index
 * SC: O(N)         -> Depth of reccurrsion tree
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        perm(nums, 0);
        return ans;
    }
    
    private void perm(int[] nums, int start) {
        if (start == nums.length - 1) {
            ans.add(toList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // swap
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            perm(nums, start + 1);
            // swap back
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
    
    private List<Integer> toList(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            ans.add(nums[i]);
        return ans;
    }
}
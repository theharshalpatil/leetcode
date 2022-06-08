/**
 * Do a backtracking by takeing each element in position 'i' and permute on the remaining array
 * In such a way we'll create a tree whose leaves are needed permutations.
 * To elemenate dups due to repeating nums, we use a Set.
 * TC: O(N^2)       -> We take each num on a given index
 * SC: O(N)         -> Depth of reccurrsion tree
 */
class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(nums, 0);
        return new ArrayList<>(ans);
    }
    
    private void backtrack(int[] nums, int start) {
        if (start == nums.length - 1) {
            ans.add(toList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // swap
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
            
            backtrack(nums, start + 1);
            
            // swap back
            temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
        }
    }
    
    private List<Integer> toList(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int n: nums)
            ans.add(n);
        return ans;
    }
}

/**
 * Same algo with a huge improvement where we don't permute if we've seen the same int
 * on a given position. This will save any duplicates and we can get rid of the Set<> approach
 * TC: O(N^2)       -> But will avoid dups so, way faster than prev method
 * SC: O(N)
 */
 class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }
    
    private void backtrack(int[] nums, int start) {
        if (start == nums.length - 1) {
            ans.add(toList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // dont permute if we've seen same num at this pos
            if (i != start && !canPermute(i, start, nums)) continue;
            
            // swap
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
            
            backtrack(nums, start + 1);
            
            // swap back
            temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
        }
    }
    
    // If same element is encountered on a pos, don't permute
    private boolean canPermute(int curr, int start, int[] nums) {
        for (int i = start; i < curr; i++)
            if (nums[curr] == nums[i]) return false;
        return true;
    }
    
    private List<Integer> toList(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int n: nums)
            ans.add(n);
        return ans;
    }
}
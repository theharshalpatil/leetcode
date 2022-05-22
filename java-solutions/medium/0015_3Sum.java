/** Naive: Exceeds Time Limit
 *  TC: O(N^3)
 *  SC: O(N)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<List<Integer>>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Integer[] arr = new Integer[]{nums[i], nums[j], nums[k]};
                        Arrays.sort(arr);
                        ans.add(Arrays.asList(arr));
                    }
                }
            }
        }
        
        return new ArrayList<>(ans);
    }
}

/**
 * One loop + 2 pointer method for finding 2SUM
 * TC: O(N^2) -> Sort (nlogn) + nested for (n^2)
 * SC: O(N) -> No auxillary space if solution List not considered
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);   // Sorting so that lo-hi pointer method works
        
        int low, high, sum, len = nums.length;
        
        for (int i = 0; i < len - 2; i++) { // -2 coz we've lo-hi
            if (i==0 || (i>0 && nums[i] != nums[i-1])) {
                low = i+1; high = len - 1; sum = 0-nums[i];
                
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        // These elements shall always be sorted, i.e., i <= low <= high
                        ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[high]==nums[high-1]) high--;
                        while (low < high && nums[low] == nums[low+1]) low++;
                        high--; low++;
                    }
                    else if (nums[low] + nums[high] < sum) low++;
                    else high--;
                }
            }
        }
        
        return ans;
    }
}
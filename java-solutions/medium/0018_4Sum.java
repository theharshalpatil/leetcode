/** Recursive Generalized k-Sum
 * TC: O(N^(k-1)) -> O(n^3) for 4-Sum
 * SC: O(N) -> For storing recursion stack
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        // run out of numbers
        if (start == nums.length) return res;
        
        // k remaining values to add to sum. The average of these
        // values is at least (target/k).
        int avg = target/k;
        
        // we cannot obtain a sum of target if smallest value
        // in nums is greater than avg or if largest value in nums
        // is smaller than avg
        if (nums[start] > avg || avg > nums[nums.length - 1]) return res;
        
        if (k == 2) return twoSum(nums, target, start);
        
        for (int i = start; i < nums.length; i++) {
            if (i==start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset: kSum(nums, target - nums[i], i+1, k-1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) ++lo;
            else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) --hi;
            else res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        
        return res;
    }
}

/** Approach 2: By using HashSet
 * In 3Sum HashSet approach we only sorted the triplet.
 * It'd be impractical to sort k-length array everytime: thus we sort nums beforehand
 * Only difference here will be implementation of twoSum
 * TC: O(N^(k-1)) -> O(n^3) for 4-Sum
 * SC: O(N) -> For storing recursion stack (< N) and hashset (N - k + 2 < N)
 */
public List<List<Integer>> twoSum(int[] nums, int target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> s = new HashSet<>();

    for (int i = start; i < nums.length; ++i) {
        if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
            if (s.contains(target - nums[i])) {
                res.add(Arrays.asList(target - nums[i], nums[i]));
            }
        }
        s.add(nums[i]);
    }
                                                
    return res;
}
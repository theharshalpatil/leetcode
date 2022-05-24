/**
 * Maintain a hashmap of (target-current num) and if another num is found, you've your answer
 * TC: O(N)
 * SC: O(N) -> For the hashmap
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> found = new HashMap<Integer, Integer>();
        int otherNum;
        
        for (int i = 0; i < nums.length; i++) {
            otherNum = target - nums[i];
            if (found.get(otherNum) != null) {
                return new int[]{found.get(otherNum), i};
            }
            found.put(nums[i], i);
        }
        
        return new int[]{0, 0};
    }
}

/**
 * Approach 2: Two-Pointer!
 */
import java.util.*;

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
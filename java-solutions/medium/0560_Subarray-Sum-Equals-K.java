/**
 * Calculate the number of prefixes that can be removed from curr array
 * Then accumulate them to find the ans!
 * TC: O(N)
 * SC: O(N)
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap();
        prefixSum.put(0, 1);
        int ans = 0, currSum = 0;
        
        for (int n: nums) {
            currSum += n;
            int diff = currSum - k;
            if (prefixSum.containsKey(diff))
                ans += prefixSum.get(diff);
            if (prefixSum.containsKey(currSum))
                prefixSum.put(currSum, prefixSum.get(currSum) + 1);
            else
                prefixSum.put(currSum, 1);
        }
        
        return ans;
    }
}
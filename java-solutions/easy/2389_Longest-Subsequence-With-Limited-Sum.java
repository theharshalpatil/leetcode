/**
 * For each query we need to pick max elements (viz. each element as small as possible)
 * TC: O(NlogN) + O(N*Q)    -> Sort nums, run through nums for each q in queries
 * SC: O(1)                 -> No extra Space
 */
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int N = queries.length;
        int[] ans = new int[N];
        
        for (int i = 0; i < N; i++) {
            int q = queries[i];
            int currSum = 0, j = 0;
            while (j < nums.length && q >= currSum + nums[j]) {
                currSum += nums[j];
                j++;
            }
            ans[i] = j;
        }
        
        return ans;
    }
}


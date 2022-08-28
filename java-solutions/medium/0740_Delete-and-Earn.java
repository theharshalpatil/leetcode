/** Dynamic Programming
 * If you pick a number, you can pick all it's occurences so now you've to have them in sorted order.
 * once in sorted order, it's like house robber problem
 * TC: O(10^4)
 * SC: O(10^4)
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10002]; // nums[i] can be 10^4 ~ idx 10001
        
        // get the sum you can earn from each number
        for (int n: nums) sum[n] += n;
        
        // to pick or not to pick (as in house robber)
        for (int i = 2; i < sum.length; i++)
            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
        
        return sum[10001];
    }
}


/** Smart DP (use two vars for prev states & min-max to restrict loop)
 * TC: O(MAX-MIN + N)
 * SC: O(N)             -> for count map
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        int prevIncEarn = 0, prevExcEarn = 0;
        for (int i = min; i <= max; i++) {
            int incEarn = prevExcEarn + i*count.getOrDefault(i, 0);
            int excEarn = Math.max(prevExcEarn, prevIncEarn);
            prevIncEarn = incEarn;
            prevExcEarn = excEarn;
        }
        
        return Math.max(prevIncEarn, prevExcEarn);
    }
}

/** Count and check
 * For every power of 2, check if the number in original 'n' are equal in occurences
 * TC: O((logN)^2)  -> there are logN powers of 2 and each comparision has logN complexity
 * SC: O(logN)
 */
class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] nums = count(n);
        // as 2^31 > 10^9 viz. the limit
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(nums, count(1 << i)))
                return true;
        }
        return false;
    }
    
    private int[] count(int n) {
        int[] res = new int[10];
        while (n > 0) {
            res[n%10]++;
            n /= 10;
        }
        return res;
    }
}

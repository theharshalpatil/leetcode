/**
 * Recursive solution. Compute all the permutations as int and then sort them
 * Return k'th value in the permutations list.
 * OPTIMIZATION: Can improve to calculate inorder and stop when k'th permutation is reached
 * TC: O(N!)
 * SC: O(N!)
 * Very inefficient
 */
class Solution {
    List<Integer> permutations;
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i+1;
        
        permutations = new ArrayList<>();
        limit = k;
        permute(nums, 0);
        Collections.sort(permutations);
        return permutations.get(k - 1).toString();
    }
    
    private void permute(int[] nums, int start) {
        if (start == nums.length - 1) {
            permutations.add(toInt(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // swap
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            
            permute(nums, start + 1);   // dfs
            
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
    
    private int toInt(int[] nums) {
        int ans = 0;
        for (int n: nums) ans = ans*10 + n;
        return ans;
    }
}

/** Build k'th permutation of N digits (possible N! permutations)
 * Notice: say 1st position for k'th permutation will be [k/(n-1)!]
 * Then the remaining possible permutations to check will be (N-1)!
 * TC: O(N)     -> 3 loops of len N
 * SC: O(N)     -> Storing digits & factorials
 */
 class Solution {
    public String getPermutation(int n, int k) {
        // Store factorials to make them handy
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = fact[i-1] * i;
        
        // All possible digits
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) digits.add(i);
        
        StringBuilder ans = new StringBuilder("");
        k--;        // 0-indexed calculations
        for (int i = 1; i <= n; i++) {
            int idx = k / fact[n - i];
            ans.append(digits.get(idx));
            digits.remove(idx);
            k -= idx * fact[n - i];
        }
        
        return ans.toString();
    }
    
}
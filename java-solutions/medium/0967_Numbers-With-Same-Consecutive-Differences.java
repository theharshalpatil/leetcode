/** Breadth First Search
 * TC: O(2^N)   -> A binary tree with (~2^N nodes) is formed during the search.
 * SC: O(2^N)   -> At each level the queue size can go upto (9*2^(i-1)) ~ O(2^N) in wost case
 */
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < 10; i++) q.add(i);
        
        for (int len = 1; len < n; len++) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                int unitDigit = curr % 10;
                
                int upper = unitDigit + k;  // next greater
                if (0 <= upper && upper < 10)
                    q.add(curr * 10 + upper);
                int lower = unitDigit - k;  // prev smaller
                // checking for 'k!=0' as if k==0,
                // then the new num is already considered above
                if (k != 0 && 0 <= lower && lower < 10)
                    q.add(curr * 10 + lower);
            }
        }
        
        int N = q.size();
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            int curr = q.poll();
            ans[i] = curr;
        }
        
        return ans;
    }
}

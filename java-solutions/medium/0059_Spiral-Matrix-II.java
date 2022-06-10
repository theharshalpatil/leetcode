/**
 * Traverse top row, dec top, right col, dec right, bot row, inc bot, left row, inc left
 * This will create a spiral. Stop when bot > top || left > right
 * TC: O(N^2)       -> N is the input. Each place of N*N matrix will be visited once
 * SC: O(1)
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int T = 0, B = n-1, L = 0, R = n-1;
        int val = 1;
        
        while (true) {
            for (int i = L; i <= R; i++) ans[T][i] = val++;
            if (B < ++T) break;
            for (int i = T; i <= B; i++) ans[i][R] = val++;
            if (--R < L) break;
            for (int i = R; i >= L; i--) ans[B][i] = val++;
            if (--B < T) break;
            for (int i = B; i >= T; i--) ans[i][L] = val++;
            if (R < ++L) break;
        }
        
        return ans;
    }
}
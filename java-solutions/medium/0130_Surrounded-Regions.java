/** DFS
 * We track all the O's connected to border by marking them '#' using DFS. This also helps keep track of seen cells
 * We then capture all remaining O's by making them X. And reclaim '#' by making them O.
 * TC: O(M * N) -> May visit each node once for capture, and once for reclaimation
 * SC: O(1)     -> No extra space required
 */
class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        
        // for first and last row
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[m-1][i] == 'O')
                dfs(board, m-1, i);
        }
        
        // for first and last col
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][n-1] == 'O')
                dfs(board, i, n-1);
        }
        
        // Capture all remaining O's and corrects #'s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    
    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        if (board[r][c] == '#' || board[r][c] == 'X') return;
        board[r][c] = '#';
        dfs(board, r-1, c);
        dfs(board, r+1, c);
        dfs(board, r, c-1);
        dfs(board, r, c+1);
    }
}
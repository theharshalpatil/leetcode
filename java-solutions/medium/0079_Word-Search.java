/** Simulation - DFS
 * TC: O(M * N * 4^len(word))
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] seen = new boolean[rows][cols];
        boolean ans = false;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    seen[i][j] = true;
                    ans = simulate(board, word.substring(1), seen, i, j);
                    seen[i][j] = false;
                }
                if (ans) break;
            }
            if (ans) break;
        }
        
        return ans;
    }
    
    private boolean simulate(char[][] board, String word, boolean[][] seen, int i, int j) {
        if (word.length() == 0) return true;
        boolean ans = false;
        char c = word.charAt(0);
        if (i > 0 && !(seen[i-1][j]) && c == board[i-1][j]) {
            seen[i-1][j] = true;
            ans = simulate(board, word.substring(1), seen, i-1, j);
            if (ans) return true;
            seen[i-1][j] = false;
        }
        if (j > 0 && !(seen[i][j-1]) && c == board[i][j-1]) {
            seen[i][j-1] = true;
            ans = simulate(board, word.substring(1), seen, i, j-1);
            if (ans) return true;
            seen[i][j-1] = false;
        }
        if (i < board.length - 1 && !(seen[i+1][j]) && c == board[i+1][j]) {
            seen[i+1][j] = true;
            ans = simulate(board, word.substring(1), seen, i+1, j);
            if (ans) return true;
            seen[i+1][j] = false;
        }
        if (j < board[0].length - 1 && !(seen[i][j+1]) && c == board[i][j+1]) {
            seen[i][j+1] = true;
            ans = simulate(board, word.substring(1), seen, i, j+1);
            if (ans) return true;
            seen[i][j+1] = false;
        }
        return false;
    }
}

/**
 * Cleanup on above
 * NOTE: This is around 7x time heavy and 4x space heavy on leetcode
 */
 class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] seen = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (simulate(board, word, seen, i, j)) return true;
            }
        }
        
        return false;
    }
    
    private boolean simulate(char[][] board, String word, boolean[][] seen, int i, int j) {
        if (word.length() == 0) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
           || word.charAt(0) != board[i][j] || seen[i][j])
            return false;
        
        seen[i][j] = true;
        boolean ans = (simulate(board, word.substring(1), seen, i+1, j)
                      || simulate(board, word.substring(1), seen, i, j+1)
                      || simulate(board, word.substring(1), seen, i-1, j)
                      || simulate(board, word.substring(1), seen, i, j-1));
        seen[i][j] = false;
        return ans;
    }
}
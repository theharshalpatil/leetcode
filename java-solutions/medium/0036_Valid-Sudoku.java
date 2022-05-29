/** Brute Force
 * TC: O(n^4) -> n=9
 * SC: O(n) -> one row/col/block at a time
 * Leetcode execution time: 5ms
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> seen = new HashSet<>();
        
        // check row wise
        for (int i = 0; i < 9; i++) {
            seen.clear();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.' && seen.contains(c)) return false;
                else if (c != '.') seen.add(c);
            }
        }
        
        // check col wise
        for (int i = 0; i < 9; i++) {
            seen.clear();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.' && seen.contains(c)) return false;
                else if (c != '.') seen.add(c);
            }
        }
        
        // check square wise
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                seen.clear();
                for (int a = i; a < i+3; a++) {
                    for (int b = j; b < j+3; b++) {
                        char c = board[a][b];
                        if (c != '.' && seen.contains(c)) return false;
                        else if (c != '.') seen.add(c);
                    }
                }
            }
        }
        
        return true;
    }
}

/** Using Strings + Set to our advantage
 * The downfall of such an approach is that string comparison will consume time!
 * Leetcode execution time: 26ms -> Way worse than bruteforce
 * TC: O(n^2)
 * SC: O(n^2)
 */
 class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        // check for all at once
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!seen.add(c + " in row " + i) ||
                        !seen.add(c + " in col " + j) ||
                        !seen.add(c + " in block " + i/3 + "-" + j/3)) return false;
                }
            }
        }
        
        return true;
    }
}
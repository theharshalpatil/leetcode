/**
 * BFS - Maintain a seen[][] and don't repeat a visited node
 * Start off with 0 (viz. 0 distance from 0) and then build up to other ones
 * TC: O(N*M)     -> each node visited once
 * SC: O(N*M)     -> seen[][] & Queue
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        boolean[][] seen = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    seen[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int row = curr[0] + dir[i][0];
                int col = curr[1] + dir[i][1];
                if (row < 0 || row >= rows || col < 0 || col >= cols || seen[row][col])
                    continue;
                seen[row][col] = true;
                mat[row][col] = mat[curr[0]][curr[1]] + 1;
                q.offer(new int[]{row, col});
            }
        }
        
        return mat;
    }
}

/** Dynamic Programming
 * As directed in the comments
 * TC: O(M*N)
 * SC: O(1)
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        
        // Replace all the 1's with INTMAX
        // So that the min() works
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Subtracting some buffer as we're gonna later check with +1
                if (mat[i][j] == 1) mat[i][j] = Integer.MAX_VALUE - 10000;
            }
        }
        
        // from top-left to bot-right
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0)
                    continue;
                else {
                    if (i > 0) // check top
                        mat[i][j] = Math.min(mat[i][j], mat[i-1][j] + 1);
                    if (j > 0) // check left
                        mat[i][j] = Math.min(mat[i][j], mat[i][j-1] + 1);
                }
            }
        }
        
        // from bot-right to top-left
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] == 0) continue;
                else {
                    if (i < rows - 1) // check bot
                        mat[i][j] = Math.min(mat[i][j], mat[i+1][j] + 1);
                    if (j < cols - 1) // check right
                        mat[i][j] = Math.min(mat[i][j], mat[i][j+1] + 1);
                }
            }
        }
        
        return mat;
    }
}
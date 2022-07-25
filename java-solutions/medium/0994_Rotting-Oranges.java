/** Breadth-First Search
 * With each level, note the max time taken to rot an orange
 * If we're able to rot all oranges, return the time else -1
 * TC: O(N*M)     -> Not visiting a cell more than twice (first for getting initial queue, then BFS)
 * SC: O(N*M)     -> Queue can take all oranges if grid is filled with rotten oranges
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int totalOranges = 0;
        
        // Each entry stores {row, col, timeToRot}
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j, 0});
                if (grid[i][j] != 0) totalOranges++;
            }
        }
        
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rotten = 0, timeToRot = 0;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            rotten++;
            timeToRot = Math.max(timeToRot, curr[2]);
            
            for (int i = 0; i < 4; i++) {
                int r = curr[0] + dir[i][0];
                int c = curr[1] + dir[i][1];
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                    grid[r][c] = 2;
                    q.offer(new int[]{r, c, curr[2] + 1});
                }
            }
        }
        
        if (rotten == totalOranges) return timeToRot;
        return -1;
    }
}
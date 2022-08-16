/** Classic BFS
 * TC: O(N*M)   -> Each node will be visited at max once
 * SC: O(N*M)   -> Queue size
 */
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        
        // run bfs
        int rows = grid.length, cols = grid[0].length;
        if (grid[rows-1][cols-1] != 0) return -1;
        
        int[][] dirs = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<Integer, Integer> curr = q.poll();
                int r = curr.getKey();
                int c = curr.getValue();
                if (r == rows - 1 && c == cols - 1) return ans;
                for (int i = 0; i < 8; i++) {
                    int x = r + dirs[i][0];
                    int y = c + dirs[i][1];
                    if (x >= rows || y >= cols || x < 0 || y < 0) continue;
                    if (grid[x][y] == 0) q.add(new Pair(x, y));
                    grid[x][y] = 1; // mark seen so we don't add to Q again
                }
            }
            ans += 1;
        }
        
        return -1;
    }
}

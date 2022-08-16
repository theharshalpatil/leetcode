/**
 * First run a DFS on one island and mark it as 2 to distinguush
 * Then, run a BFS from all cells of island marked 1 untill we find 2!
 * TC: O(N*N)   -> To mark one island (DFS) + to search second island (BFS)
 * SC: O(N*N)   -> Stack for DFS / Queue for BFS may contain all elements
 */
class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        
        // use dfs to mark one island with different number; say 2
        boolean marked = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    markIsland(grid, i, j);
                    marked = true;
                    break;
                }
            }
            if (marked) break;
        }
        
        // Run BFS from all cells of island 1
        Queue<List<Integer>> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    q.add(Arrays.asList(new Integer[]{i, j}));
            }
        }
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                List<Integer> curr = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = curr.get(0) + dirs[i][0];
                    int y = curr.get(1) + dirs[i][1];
                    if (x < 0 || y < 0 || x >= n || y >= n) continue;
                    if (grid[x][y] == 2) return dist;
                    if (grid[x][y] == 0) {
                        q.add(Arrays.asList(new Integer[]{x, y}));
                        grid[x][y] = 1;
                    }
                }
            }
            dist += 1;
        }
        
        return 0;
    }
    
    // DFS to mark one island as 2
    private void markIsland(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length)
            return;
        if (grid[i][j] != 1) return;
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            markIsland(grid, i + dirs[k][0], j + dirs[k][1]);
        }
    }
}
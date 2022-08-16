/**
 * Just run a BFS untill we hit a boundary
 * TC: O(N^2)
 * SC: O(N^2)
 */
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        // Not including entrance in queue as that can't be counted as exit
        for (int i = 0; i < 4; i++) {
            int x = entrance[0] + dirs[i][0];
            int y = entrance[1] + dirs[i][1];
            if (x >= 0 && y >= 0 && x < rows && y < cols && maze[x][y] == '.')
                q.add(new int[]{x, y});
        }
        maze[entrance[0]][entrance[1]] = '+';
        
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                if (curr[0] == 0 || curr[1] == 0 || curr[0] == rows - 1 || curr[1] == cols-1)
                    return dist;
                for (int i = 0; i < 4; i++) {
                    int x = curr[0] + dirs[i][0];
                    int y = curr[1] + dirs[i][1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols) continue;
                    if (maze[x][y] == '.') {
                        q.add(new int[]{x, y});
                        maze[x][y] = '+';
                    }
                }
            }
            dist += 1;
        }
        
        return -1;
    }
}
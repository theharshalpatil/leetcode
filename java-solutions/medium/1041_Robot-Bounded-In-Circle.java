/**
 * Simulation: Note that robot will return in circle if it comes back to start / dir changes
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    // 0-North, 1-West, 2-South, 3-East
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int dir = 0;
        
        int[] curr = new int[]{0, 0};
        for (char i: instructions.toCharArray()) {
            if (i == 'G') {
                curr[0] += dirs[dir][0];
                curr[1] += dirs[dir][1];
            }
            else if (i == 'L') {
                if (dir == 3) dir = 0;
                else dir++;
            }
            else if (i == 'R') {
                if (dir == 0) dir = 3;
                else dir--;
            }
        }
        
        return (curr[0] == 0 && curr[1] == 0) || dir != 0;
    }
}

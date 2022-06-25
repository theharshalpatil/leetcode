/** BFS Approach
 * We check each level in the BFS Travarsal but only add idx having '0' to our queue
 * TC: O(N)
 * SC: O(N)
 */
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // BFS approach
        Queue<Integer> q = new LinkedList<>(); // stores idx to jump from
        q.add(0);
        int farthest = 0;
        
        while (!q.isEmpty()) {
            int idx = q.poll();
            int start = Math.max(idx + minJump, farthest + 1);
            for (int j = start; j < Math.min(idx + maxJump + 1, s.length()); j++) {
                if (s.charAt(j) == '0') {
                    q.add(j);
                    if (j == s.length() - 1) return true;
                }
            }
            farthest = idx + maxJump;
        }
        
        return false;
    }
}
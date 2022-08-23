/**
 * Count network rank for every pair.
 * TC: O(N^2)
 * SC: O(N + E)
 */
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new HashSet<>());
        for (int[] road: roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int degree = graph.get(i).size() + graph.get(j).size();
                if (graph.get(i).contains(j)) degree--;
                ans = Math.max(ans, degree);
            }
        }
        
        return ans;
    }
}

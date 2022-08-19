/**
 * Use traversal to find the number of clusters, connect them with (clusters - 1) connections
 * TC: O(N)
 * SC: O(N)
 */
class Solution {
    private HashMap<Integer, List<Integer>> graph;
    
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) return -1;
    
        // Make a adjecency list
        graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());
        for (int[] e: connections) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // do a traversal to determine how many clusters of comps are present
        boolean[] connected = new boolean[n];
        int clusters = 0;
        for (int i = 0; i < n; i++) {
            if (!connected[i]) {
                clusters++;
                dfs(i, connected);
            }
        }
        
        // To connect 'n' clusters, we need 'n-1' connections
        return clusters - 1;
    }
    
    private void dfs(int node, boolean[] connected) {
        connected[node] = true;
        for (int n: graph.get(node)) {
            if (!connected[n])
                dfs(n, connected);
        }
    }
}

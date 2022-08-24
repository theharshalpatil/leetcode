/** DFS & Graph-Coloring
 * TC: O(N) -> Each node is visited once
 * SC: O(N) -> Recursion stack may go upto size = number of nodes
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, 0);
        
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !isBipartite(graph, color, i, 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isBipartite(int[][] graph, int[] color, int node, int prevColor) {
        color[node] = prevColor;
        
        for (int i: graph[node]) {
            if (color[i] == prevColor) return false;
            if (color[i] == 0 && !isBipartite(graph, color, i, -prevColor))
                return false;
        }
        
        return true;
    }
}

/** BFS
 * TC: O(N) -> Each node visited once
 * SC: O(N) -> Size of quue
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, 0);
        
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            Queue<Integer> q = new LinkedList<>();
            color[i] = 1;
            q.add(i);
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int neigh: graph[curr]) {
                    if (color[curr] == color[neigh]) return false;
                    if (color[neigh] == 0) {
                        color[neigh] = -color[curr];
                        q.add(neigh);
                    } 
                }
            }
        }
        
        return true;
    }
}

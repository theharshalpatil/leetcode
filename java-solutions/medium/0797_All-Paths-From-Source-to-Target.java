/**
 * Classic DFS
 * TC: O(N * 2^N)   -> Each node gives a exponential possibilities
 * SC: O(N * 2^N)   -> Size of Stack
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        ans = new ArrayList<>();
        dfs(0, graph, new ArrayList<Integer>());
        return ans;
    }
    
    private void dfs(int node, int[][] graph, List<Integer> path) {
        path.add(node);
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int n: graph[node]) {
                dfs(n, graph, path);
            }
        }
        path.remove(path.size() - 1);
    }
}

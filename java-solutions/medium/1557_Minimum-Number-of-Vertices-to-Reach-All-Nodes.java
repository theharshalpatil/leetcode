/**
 * Just count the nodes with no incoming edges,
 * All other nodes can eventually be reached - as they've incoming edges
 * TC: O(Max(N, E))
 * SC: O(N)
 */
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for (List<Integer> e: edges)
            indegree[e.get(1)]++;
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                ans.add(i);
        }
        
        return ans;
    }
}

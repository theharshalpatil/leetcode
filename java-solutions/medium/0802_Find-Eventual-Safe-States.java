/**
 * Create a graph (node->child) and a rgraph (node->parent)
 * If a node has no child (graph.get(n).isEmpty()), then it is a safe node
 *      Remove links with all parents of this child (offer in queue)
 *      Check for no childs for all these parents to check if they're eventually safe
 * TC: O(N)     -> You'll check for safe node only once
 * SC: O(N + E) -> Map will store N nodes with E edges * 2
 */
class Solution {
    public List<Integer> eventualSafeNodes(int[][] grid) {
        int n = grid.length;
        
        List<Set<Integer>> graph = new ArrayList<>();
        List<Set<Integer>> rgraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
            rgraph.add(new HashSet<>());
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (grid[i].length == 0)
                q.offer(i);
            for (int j: grid[i]) {
                graph.get(i).add(j);
                rgraph.get(j).add(i);
            }
        }
        
        // remove links
        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int j = q.poll();
            safe[j] = true;
            for (int i: rgraph.get(j)) {
                graph.get(i).remove(j);
                if (graph.get(i).isEmpty())
                    q.offer(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (safe[i]) ans.add(i);
        
        return ans;
    }
}

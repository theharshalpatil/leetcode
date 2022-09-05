/** Level-Order traversal using BFS
 * TC: O(N)     -> Each node visited once
 * SC: O(N)     -> All nodes could be children of root - making Queue size (N-1)
 */
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                Node curr = q.poll();
                level.add(curr.val);
                for (Node child: curr.children) {
                    if (child != null) q.add(child);
                }
            }
            ans.add(level);
        }
        
        return ans;
    }
}

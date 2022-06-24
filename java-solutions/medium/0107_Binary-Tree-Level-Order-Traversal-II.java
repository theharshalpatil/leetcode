/**
 * Level Order Traversal. Reverse the resultant list.
 * TC: O(N + logN) ~ O(N)     -> To visit each node once + O(levels) to reverse but levels is O(logN) so insignificant
 * SC: O(N)
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() > 0) {
            int qlen = q.size();
            List<Integer> level = new ArrayList<>();
            while(qlen-- != 0) {
                TreeNode curr = q.remove();
                if (curr != null) {
                    level.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            if (!level.isEmpty()) ans.add(level);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}
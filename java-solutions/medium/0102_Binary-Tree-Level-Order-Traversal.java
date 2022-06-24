/** TC: O(N) -> visit each node once
 *  SC: O(N/2) ~ O(N)   -> Since last level can have approx n/2 elements
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() > 0) {
            int qLen = q.size();
            List<Integer> level = new ArrayList<>();
            while (qLen-- != 0) {
                TreeNode n = q.remove();
                if (n != null) {
                    level.add(n.val);
                    q.add(n.left);
                    q.add(n.right);
                }
            }
            if (!level.isEmpty()) ans.add(level);
        }
        
        return ans;
    }
}
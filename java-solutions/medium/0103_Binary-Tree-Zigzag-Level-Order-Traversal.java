/**
 * Level order traversal - just reverse the even levels (i.e., levels considered till now are odd)
 * TC: O(N)     -> Visit each node once & reverse levels
 * SC: O(N/2)   -> Since last level can have approx N/2 elements
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (!level.isEmpty()) {
                if (ans.size() % 2 == 1) Collections.reverse(level);
                ans.add(level);
            }
        }
        
        return ans;
    }
}
/** Breadth First Search
 * Get sum for each level and divide by size of the level to get avg
 * TC: O(N) -> Each node visited once
 * SC: O(M) -> Max size of queue (i.e. number of nodes in longest level)
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double avg = 0;
            int i = size;
            while (i-- > 0) {
                TreeNode curr = q.poll();
                avg += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            avg /= size;
            ans.add(avg);
        }
        
        return ans;
    }
}

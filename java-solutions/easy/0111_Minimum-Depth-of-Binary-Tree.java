/** DFS Approach
 * TC: O(N)     -> visit each node once
 * SC: O(logN)  -> Height of recursion stack
 */
class Solution {   
    public int minDepth(TreeNode root) {
        return getMinDepth(root, 1);
    }
    
    public int getMinDepth(TreeNode root, int depth) {
        if (root == null) return depth - 1;
        if (root.right == null && root.left == null) return depth;
        
        if (root.left == null && root.right != null)
            return getMinDepth(root.right, depth + 1);
        if (root.left != null && root.right == null)
            return getMinDepth(root.left, depth + 1);
        
        return Math.min(getMinDepth(root.left, depth + 1),
                        getMinDepth(root.right, depth + 1));
    }
}

/** BFS Approach
 * TC: O(N)
 * SC: O(N/4)   -> since 2nd last level may have N/4 elements. QUeue size
 * WAY faster on leetcode
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int qlen = q.size();
            while (qlen-- > 0) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) return depth;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            depth++;
        }
        
        return depth;
    }
}
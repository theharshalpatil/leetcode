/**
 * DFS, maintain sum to reach. if its reached return true
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) return true;
        }
        
        return hasPathSum(root.left, targetSum - root.val)
            || hasPathSum(root.right, targetSum - root.val);
    }
}
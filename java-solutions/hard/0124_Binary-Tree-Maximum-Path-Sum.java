/**
 * For each node, consider two cases. Either this node is the root of the path
 * or This node leads to the node which is root of the max path
 * Maintain ans in maxVal. And return from node as if it were part of the path.
 * TC: O(N)
 * SC: O(H)
 */
class Solution {
    int maxVal = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        inorderSum(root);
        return maxVal;
    }
    
    private int inorderSum(TreeNode node) {
        if (node == null) return 0;

        // No point adding negative values (as we wanna maximize path)
        int leftVal = Math.max(0, inorderSum(node.left));
        int rightVal = Math.max(0, inorderSum(node.right));
        
        // considering this node as the root of maxPath, with split on this node
        maxVal = Math.max(maxVal, node.val + leftVal + rightVal);
        
        // Only one side can be considered as path, without split on this node
        return node.val + Math.max(leftVal, rightVal);
    }
}
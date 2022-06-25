/**
 * For a BST, inorder traversal should be in sorted order.
 * We find the two elements that are violating this order and swap them
 * TC: O(N)
 * SC: O(N) -> to make inorder array and find violation
 */

/**
 * In above approach, to find violation, we need only previous value to be compared
 * This can be done in constant space by maintaining prev node. and if our conditions satisfy, we've found target nodes
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    TreeNode prev, toSwap, swapWith;
    
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        
        inorder(root);
        
        if (toSwap != null && swapWith != null) {
            int temp = toSwap.val;
            toSwap.val = swapWith.val;
            swapWith.val = temp;
        }
    }
    
    public void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        
        if (prev != null && node.val < prev.val && toSwap == null) toSwap = prev;
        if (prev != null && node.val < prev.val && toSwap != null) swapWith = node;
        prev = node;
        
        inorder(node.right);
    }
}
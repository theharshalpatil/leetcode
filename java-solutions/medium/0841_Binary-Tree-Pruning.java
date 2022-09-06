/**
 * Do a recursive serach for one. if '1' is found retain the subtree, else prune
 * TC: O(N)     -> Each node visited once
 * SC: O(H)     -> Height of the recursion stack will be height of tree
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        if (hasOne(root))
            return root;
        return null;
    }
    
    public boolean hasOne(TreeNode root) {
        if (root == null) return false;
        if (root.right == null && root.left == null)
            return root.val == 1;
        
        boolean rightHasOne = hasOne(root.right);
        boolean leftHasOne = hasOne(root.left);
        if (!rightHasOne) root.right = null;
        if (!leftHasOne) root.left = null;
        return root.val == 1 || rightHasOne || leftHasOne;
    }
}

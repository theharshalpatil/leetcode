/**
 * Recursively check the height of right & left subtree of each node
 * if diff is more than 1, mark balanced as false
 * TC: O(N)     -> each node visited once
 * SC: O(logN)  -> size of recursion stack
 */
class Solution {
    boolean balanced = true;
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        
        height(root);
        return balanced;
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (!balanced) return 0;    // terminate if found to be unbalanced
        
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) balanced = false;
        return Math.max(left, right) + 1;
    }
}

/**
 * Return -1 if unbalanced node is found else return height
 * TC: O(N)
 * SC: O(logN)  -> height of recursion tree
 */
 class Solution {
    
    public boolean isBalanced(TreeNode root) {
        // will get -1 if there's unbalace on any node
        return dfsHeight(root) != -1;
    }
    
    int dfsHeight(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = dfsHeight(root.left);
        if(leftHeight == -1) return -1;     // if unbalance in left subtree
        int rightHeight = dfsHeight(root.right);
        if(rightHeight == -1) return -1;    // if unbalance in right subtree
        
        // if unbalance here on root
        if(Math.abs(leftHeight - rightHeight) >1 ) return -1;
        return Math.max(leftHeight,rightHeight) +1; // return height so far
    }
    
}
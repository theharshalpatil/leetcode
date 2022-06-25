/**
 * Build LL with preorder traversal
 * TC: O(N)
 * SC: O(N)     -> As we create new list
 */
class Solution {
    TreeNode curr, head;
    public void flatten(TreeNode root) {
        if (root == null) return;
        curr = new TreeNode(root.val);
        head = curr;
        preorder(root.left);
        preorder(root.right);
        root.left = null;
        root.right = head.right;
    }
    
    public void preorder(TreeNode node) {
        if (node == null) return;
        
        curr.right = new TreeNode(node.val);
        curr = curr.right;
        
        preorder(node.left);
        preorder(node.right);
    }
}

/**
 * Morris Traversal. Rightest node in left subtree shall come after the immediate right node
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) prev = prev.right;
                prev.right = curr.right; // as this will always be inorder
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
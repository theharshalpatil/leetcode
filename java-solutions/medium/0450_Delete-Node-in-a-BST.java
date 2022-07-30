/**
 * Put right sub-tree (ST) in node's place & left ST to the left of leftest node in right ST
 * Corner-cases: if left ST is null, just give right ST and vice-versa
 * TC: O(H)     -> Only look at nodes == Height of the tree
 * SC: O(H)     -> Size of recursion stack
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            TreeNode ans = root;
            ans = ans.right;
            TreeNode curr = ans;
            while (curr != null && curr.left != null)
                curr = curr.left;
            curr.left = root.left;
            root = ans;
        }
        if (root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        return root;
    }
}

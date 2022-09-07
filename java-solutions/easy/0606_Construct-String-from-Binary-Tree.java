/** Just do a conditional DFS
 * TC: O(N) -> each node visited once
 * SC: O(H) -> Height of recursion tree == height of tree
 */
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        build(root, sb);
        return sb.toString();
    }
    
    public void build(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.left != null) {
            sb.append('(');
            build(node.left, sb);
            sb.append(')');
        }
        if (node.left == null && node.right != null) {
            sb.append('(');
            sb.append(')');
        }
        if (node.right != null) {
            sb.append('(');
            build(node.right, sb);
            sb.append(')');
        }
    }
}

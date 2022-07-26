/**
 * Recurssive. Basically if any of the sides + itself results in 2 true's, it means this is the LCA
 * TC: O(N)
 * SC: O(N)     -> Recursion Stack in skewed tree
 */
class Solution {
    TreeNode ans;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        dfs(root, p, q);
        return ans;
    }
    
    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        
        int left = dfs(node.left, p, q) ? 1 : 0;
        int right = dfs(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;
        
        if (mid + left + right >= 2) ans = node;
        
        return (mid + left + right > 0);
    }
}
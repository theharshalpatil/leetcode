/**
 * As you traverse to each children, keep track of max number in the path.
 * Count a node if you encounter a node with greater/equal value than maxSoFar
 * TC: O(N)     -> Each node is visited once
 * SC: O(H)     -> Recursion tree
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }
    
    public int countGoodNodes(TreeNode root, int maxSoFar) {
        if (root == null) return 0;
        int ans = 0;
        if (root.val >= maxSoFar) ans += 1;
        maxSoFar = Math.max(maxSoFar, root.val);
        return ans
            + countGoodNodes(root.left, maxSoFar)
            + countGoodNodes(root.right, maxSoFar);
    }
}

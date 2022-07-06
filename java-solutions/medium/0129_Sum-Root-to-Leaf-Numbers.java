/** Recursion
 * TC: O(N) -> Each node is visited once
 * SC: O(1) -> No extra auxilliary space
 */
class Solution {
    int ans;
    
    public int sumNumbers(TreeNode root) {
        ans = 0;
        getSum(root, 0);
        return ans;
    }
    
    public void getSum(TreeNode node, int num) {
        if (node == null) return;
        if (node.left == null && node.right == null)
            ans += (num*10 + node.val);
        getSum(node.left, num*10 + node.val);
        getSum(node.right, num*10 + node.val);
    }
}
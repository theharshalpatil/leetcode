/** DFS
 * TC: O(N)
 * SC: O(H)
 */
class Solution {
    int ans;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        ans = 0;
        int[] count = new int[10];
        Arrays.fill(count, 0);
        dfs(root, count);
        return ans;
    }
    
    private void dfs(TreeNode node, int[] count) {
        if (node == null) return;
        count[node.val]++;
        if (node.left == null && node.right == null) {
            int odd = 0;
            for (int c: count) if (c % 2 == 1) odd++;
            if (odd == 0 || odd == 1) ans++;
        }
        dfs(node.left, count);
        dfs(node.right, count);
        count[node.val]--;
    }
}

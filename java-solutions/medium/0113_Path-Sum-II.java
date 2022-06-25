/**
 * DFS. Maintain Path as list along the way.
 * Add path to answer if the sum is reached
 * TC: O(N)
 * SC: O(N)     -> if the tree is skewed and path size reaches N
 */
class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPath(root, targetSum, path);
        return ans;
    }
    
    public void findPath(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) return;
        
        // if leaf node and sum reached
        if (root.right == null && root.left == null && targetSum == root.val) {
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        path.add(root.val);
        findPath(root.left, targetSum - root.val, path);
        findPath(root.right, targetSum - root.val, path);
        path.remove(path.size() - 1);
    }
}
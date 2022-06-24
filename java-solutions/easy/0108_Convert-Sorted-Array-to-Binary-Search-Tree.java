/**
 * Consider mid elemnt as root element to divide the remaining nums
 * into two halves almost equally. Repeat on left & right half
 * TC: O(N)     -> each node to be visited once
 * SC: O(logN)  -> size of recurssion tree
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) return new TreeNode(nums[0]);
        
        return arrayToTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode arrayToTree(int[] nums, int left, int right) {
        if (left > right) return null;
        
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToTree(nums, left, mid - 1);
        root.right = arrayToTree(nums, mid + 1, right);
        
        return root;
    }
}
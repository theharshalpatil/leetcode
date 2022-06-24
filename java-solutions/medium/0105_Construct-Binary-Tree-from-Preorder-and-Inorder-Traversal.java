/**
 * Pick root from preorder & subtrees from inorder
 * TC: O(N) -> Building inorderIdxMap + Building tree - visit each node twice
 * SC: O(N) -> For the hashmap & storing tree recurssion in-memory O(N) worst case & O(logN) average
 */
class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIdxMap;
        
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        
        // value -> it's index in inorder[]; for O(1) lookup in inorder
        inorderIdxMap = new HashMap();
        for (int i = 0; i < inorder.length; i++)
            inorderIdxMap.put(inorder[i], i);
        
        return arrayToTree(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode arrayToTree(int[] preorder, int left, int right) {
        // no elements to construct the tree
        if (left > right) return null;
        
        // select preorderIdx as root and inc it. Shall never be OOB
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        // build left & right subtree
        root.left = arrayToTree(preorder, left, inorderIdxMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIdxMap.get(rootValue) + 1, right);
        
        return root;
    }
}
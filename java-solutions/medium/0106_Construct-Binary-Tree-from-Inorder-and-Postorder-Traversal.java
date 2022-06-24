/**
 * Pick root from postorder & subtrees from inorder
 * TC: O(N) -> Building inorderIdxMap + Building tree - visit each node twice
 * SC: O(N) -> For the hashmap & storing tree recurssion in-memory O(N) worst case & O(logN) average
 */
class Solution {
    int postorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // we begin from last as this is the root
        // left -> right -> root for PostOrder traversal
        postorderIndex = postorder.length - 1;
        
        // build map for O(1) time location of root in inorder
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);
        
        return arrayToTree(postorder, 0, postorder.length - 1);
    }
    
    public TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right) return null;

        // set postorder idx as root and dec it
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        // we took root, now right -> left. Since this is reverse of post order
        root.right = arrayToTree(postorder, inorderIndexMap.get(rootVal) + 1, right);
        root.left = arrayToTree(postorder, left, inorderIndexMap.get(rootVal) -1);
        
        return root;
    }
}
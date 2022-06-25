/**
 * Basically a Level order traversal: connect each level
 * No need for special null checks as each node will have both right & left subtree
 * TC: O(N)     -> visit each node once
 * SC: O(logN)  -> since a perfect Binary Tree. Size of queue shall be max height of tree
 */
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int qlen = q.size();
            while (qlen-- > 0) {
                Node curr = q.poll();
                if (qlen != 0) curr.next = q.peek();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        
        return root;
    }
}
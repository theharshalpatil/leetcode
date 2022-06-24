/**
 * Notice how we find mid by using slow/fast pointers
 * Pick sp as mid and send rest array for right and head for left subtree
 * TC: O(NlogN)   -> to find mid you'll traverse for N/2 + 2*N/4 + 4*N/8 ... = N/2 * logN
 * SC: O(1)       -> no extra space
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        ListNode sp = head, prev = null, fp = head;
        
        while (fp != null && fp.next != null) {
            prev = sp;
            sp = sp.next;
            fp = fp.next.next;
        }
        
        prev.next = null;   // break the first list
        TreeNode root = new TreeNode(sp.val);   // first val of second list as mid val
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(sp.next);  // since, sp is already considered
        
        return root;
    }
}
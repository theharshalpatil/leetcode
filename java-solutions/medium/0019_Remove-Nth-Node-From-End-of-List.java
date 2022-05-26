/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 * TC: O(n)
 * SC: O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fp = head, sp = head;
        if (sp == null) return null;
        
        while (n-- > 0) {
            fp = fp.next;
        }
        
        if (fp == null) return head.next;
        
        while (fp.next != null) {
            fp = fp.next;
            sp = sp.next;
        }
        
        sp.next = sp.next.next;
        
        return head;
    }
}
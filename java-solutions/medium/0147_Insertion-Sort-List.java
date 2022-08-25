/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        
        ListNode prev = head, curr = head.next;
        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
                continue;
            }
            
            ListNode runner = sentinel;
            while (curr.val > runner.next.val)
                runner = runner.next;
            prev.next = curr.next;
            curr.next = runner.next;
            runner.next = curr;
            curr = prev.next;
        }
        
        return sentinel.next;
    }
}

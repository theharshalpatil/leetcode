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

 /**
  * TC: O(n)
  * SC: O(1)
  */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode track = start;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;
            int sum = a + b + carry;
            carry = sum/10;
            
            track.next = new ListNode(sum%10);
            track = track.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry > 0) {
            track.next = new ListNode(carry);
        }
        
        return start.next;
    }
}
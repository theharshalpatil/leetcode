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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode head, temp;
        
        // List 1 shall have the lowest first value always
        if (list1.val > list2.val) {
            temp = list2;
            list2 = list1;
            list1 = temp;
        }
        head = list1;
        
        
        // Merge 'em
        while (list1 != null && list1.next != null && list2 != null) {
            if (list1.val <= list2.val && list1.next.val > list2.val) {
                temp = list1.next;
                list1.next = list2;
                list2 = list2.next;
                list1.next.next = temp;
                list1 = list1.next;
            } else if (list1.val <= list2.val && list1.next.val <= list2.val) {
                list1 = list1.next;
            }
        }
        
        if (list1.next == null) {
            list1.next = list2;
        }
        
        return head;
    }
}
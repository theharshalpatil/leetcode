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
 * Sentinel-Head approach, in case we've to delete the head.
 * Maintain a predecessor to the sublist we want to delete.
 * return sentinel.next;
 * Better explaination: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;
        
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pred.next = head.next;
            } else {
                pred = pred.next;
            }
            head = head.next;
        }
        
        return sentinel.next;
    }
}
/**
 * Use a sentinel head, and if next two nodes exists, swap them
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode pred = sentinel, tmp = null;
        
        while (pred.next != null && pred.next.next != null) {
            tmp = pred.next;
            pred.next = pred.next.next;
            tmp.next = pred.next.next;
            pred.next.next = tmp;
            pred = pred.next.next;
        }
        
        return sentinel.next;
    }
}

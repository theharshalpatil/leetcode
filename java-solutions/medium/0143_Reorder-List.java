/**
 * First break the list in the middle, then reverse the second part
 * Now, mege the two lists with one-one item from each list
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public void reorderList(ListNode head) {
        // Break in the middle
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        // Reverse the second part
        ListNode second = reverse(midNext);
        
        // run two pointers on both & merge
        ListNode first = head;
        while (first != null && second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;
            first.next = second;
            second.next = next1;
            first = next1;
            second = next2;
        }
    }
    
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Create a gap of n nodes between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both until fast falls off the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow is just before the node to remove
        slow.next = slow.next.next;

        return dummy.next;
    }
}
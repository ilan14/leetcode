package linkedlist;

import base.ListNode;

/**
 * 876. Middle of the Linked List
 */
public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

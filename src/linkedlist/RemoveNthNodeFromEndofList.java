package linkedlist;

import base.ListNode;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode fast = dummyHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        ListNode slow = dummyHead;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }
}

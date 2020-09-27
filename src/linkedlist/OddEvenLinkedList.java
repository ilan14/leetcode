package linkedlist;

import base.ListNode;

/**
 * 328. Odd Even Linked List
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;

        ListNode oddTail = null;
        ListNode evenHead = new ListNode(0);
        ListNode evenTail = evenHead;
        while (cur != null && cur.next != null) {
            ListNode even = cur.next;
            cur.next = even.next;
            oddTail = cur;
            cur = cur.next;
            evenTail.next = even;
            evenTail = even;
        }

        evenTail.next = null;

        if (cur != null) {
            oddTail = cur;
        }
        oddTail.next = evenHead.next;

        return head;
    }
}

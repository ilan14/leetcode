package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 203. Remove Linked List Elements
 */
public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && next.val == val) {
                next = next.next;
            }

            cur.next = next;
            cur = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{3, 1, 2, 3, 4, 5, 3});
        head = removeElements(head, 3);
        Lists.printList(head);
    }
}

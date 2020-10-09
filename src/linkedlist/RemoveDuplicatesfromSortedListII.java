package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 82. Remove Duplicates from Sorted List II
 */
public class RemoveDuplicatesfromSortedListII {
    /**
     * 0 ms	38.5 MB
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);

        ListNode last = dummyHead;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (next == null || next.val != cur.val) {
                last.next = cur;
                last = cur;
            } else {
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }
            }
            cur = next;
        }

        last.next = null;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 5});
        head = deleteDuplicates(head);

        Lists.printList(head);
    }
}

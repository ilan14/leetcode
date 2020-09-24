package linkedlist;

import base.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode node = cur.next;
            while (node != null && node.val == cur.val) {
                node = node.next;
            }

            cur.next = node;
            cur = cur.next;
        }

        return head;
    }
}

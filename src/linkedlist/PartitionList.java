package linkedlist;

import base.ListNode;

/**
 * 86. Partition List
 */
public class PartitionList {
    /**
     * 0 ms	38.4 MB
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode greater = new ListNode(0);
        ListNode greaterTail = greater;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val < x) {
                cur = cur.next;
                continue;
            }

            ListNode next = cur.next;
            cur.next = next.next;
            greaterTail.next = next;
            greaterTail = greaterTail.next;
        }

        greaterTail.next = null;
        cur.next = greater.next;

        return dummyHead.next;
    }
}

package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 61. Rotate List
 */
public class RotateList {
    /**
     * 1 ms	38.5 MB
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }

        k = k % len;
        k = len - k;

        if (len <= 1 || k == len) {
            return head;
        }

        cur = head;
        for (int i = 1; i < k; i++) {
            cur = cur.next;
        }

        ListNode mark = cur;
        ListNode tail = mark.next;
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode newHead = mark.next;
        mark.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{1});
        ListNode result = rotateRight(head, 0);
        Lists.printList(result);
    }
}

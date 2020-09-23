package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 24. Swap Nodes in Pairs
 */
public class SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode temp = null;
            if (next != null) {
                temp = next.next;
                tail.next = next;
                tail = tail.next;
            }

            tail.next = cur;
            tail = tail.next;
            cur = temp;
        }

        tail.next = null;

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{1, 2, 3, 4, 5, 6});

        ListNode newHead = swapPairs(head);

        Lists.printList(newHead);
    }
}

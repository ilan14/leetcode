package linkedlist;

import base.ListNode;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 */
public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        cur = head;
        int num = 0;
        for (int i = length - 1; i >= 0; i--) {
            num += cur.val * Math.pow(2, i);
            cur = cur.next;
        }

        return num;
    }

    public int getDecimalValue1(ListNode head) {
        ListNode cur = head;
        int num = 0;
        while (cur != null) {
            num = num * 2 + cur.val;
            cur = cur.next;
        }

        return num;
    }
}

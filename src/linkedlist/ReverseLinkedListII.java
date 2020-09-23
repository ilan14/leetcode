package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 92. Reverse Linked List II
 */
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        int i = 1;
        while (i < m) {
            i++;
            cur = cur.next;
        }

        // 反转部分的前一个节点
        ListNode last = cur;

        // 反转部分的尾节点
        ListNode tail = cur.next;
        cur = cur.next;

        ListNode temp = null;
        while (i <= n) {
            temp = cur.next;
            cur.next = last.next;
            last.next = cur;
            cur = temp;
            i++;
        }

        tail.next = temp;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{1, 2, 3, 4, 5, 6});

        head = reverseBetween(head, 2, 4);

        Lists.printList(head);
    }
}

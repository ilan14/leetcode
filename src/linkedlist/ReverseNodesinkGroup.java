package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 25. Reverse Nodes in k-Group
 */
public class ReverseNodesinkGroup {
    /**
     * 1 ms	39.1 MB
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummpyHead = new ListNode(0);
        ListNode tail = dummpyHead;
        ListNode node = tail;

        ListNode cur = head;
        int i = 0;
        int j = 0;
        while (cur != null) {
            if (i % k == 0) {
                node = tail;
                ListNode temp = cur.next;
                tail.next = cur;
                tail = tail.next;
                cur = temp;
                j = k - 1;
                while (cur != null && j > 0) {
                    temp = cur.next;
                    cur.next = node.next;
                    node.next = cur;
                    cur = temp;
                    j--;
                }
                i += k;
            }
        }

        tail.next = null;

        if (j != 0) {
            cur = node.next;
            node.next = null;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = node.next;
                node.next = cur;
                cur = temp;
            }
        }

        return dummpyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{1, 2, 3, 4, 5});

        head = reverseKGroup(head, 3);

        Lists.printList(head);
    }
}

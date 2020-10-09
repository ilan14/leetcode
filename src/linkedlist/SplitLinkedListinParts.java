package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 725. Split Linked List in Parts
 */
public class SplitLinkedListinParts {
    /**
     * 0 ms	39 MB
     *
     * @param root
     * @param k
     * @return
     */
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        int count = length / k;
        int remain = length % k;

        ListNode[] result = new ListNode[k];
        if (count == 0) {
            cur = root;
            for (int i = 0; i < remain; i++) {
                ListNode temp = cur.next;
                cur.next = null;
                result[i] = cur;
                cur = temp;
            }
        } else {
            cur = root;
            int i = 0;
            for (; i < remain; i++) {
                result[i] = cur;
                for (int j = 0; j < count; j++) {
                    cur = cur.next;
                }
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }

            for (; i < k; i++) {
                result[i] = cur;
                for (int j = 0; j < count - 1; j++) {
                    cur = cur.next;
                }
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head1 = Lists.newLinkedList(new int[]{1, 2, 3});
        ListNode[] result1 = splitListToParts(head1, 5);

        for (ListNode head : result1) {
            Lists.printList(head);
        }

        ListNode head2 = Lists.newLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ListNode[] result2 = splitListToParts(head2, 4);

        for (ListNode head : result2) {
            Lists.printList(head);
        }
    }
}

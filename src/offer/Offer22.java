package offer;

import base.ListNode;
import base.Lists;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Offer22 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{7, 6, 5, 4, 3, 2, 1});
        ListNode result = getKthFromEnd(head, 3);
        System.out.println(result.val);
    }
}

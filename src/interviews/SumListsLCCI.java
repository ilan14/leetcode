package interviews;

import base.ListNode;

/**
 * 面试题 02.05. Sum Lists LCCI
 */
public class SumListsLCCI {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        int add = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int sum = num1 + num2 + add;

            add = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (add > 0) {
            cur.next = new ListNode(add);
        }

        return head.next;
    }
}

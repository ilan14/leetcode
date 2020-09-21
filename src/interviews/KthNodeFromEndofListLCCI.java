package interviews;

import base.ListNode;
import base.Lists;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 */
public class KthNodeFromEndofListLCCI {
    public int kthToLast(ListNode head, int k) {
        if (head == null || k <= 0) {
            return 0;
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

        return slow.val;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{7, 6, 5, 4, 3, 2, 1});
        KthNodeFromEndofListLCCI solution = new KthNodeFromEndofListLCCI();
        int result = solution.kthToLast(head, 3);
        System.out.println(result);
    }
}

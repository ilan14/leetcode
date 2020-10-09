package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 143. Reorder List
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 快慢指针找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转后半部分链表
        ListNode dummyHead = new ListNode(0);
        ListNode cur = slow.next;
        slow.next = null;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = temp;
        }

        // 遍历反转的部分链表2
        cur = head;
        ListNode cur2 = dummyHead.next;
        while (cur2 != null) {
            temp = cur.next;
            ListNode temp1 = cur2.next;
            cur2.next = cur.next;
            cur.next = cur2;
            cur = temp;
            cur2 = temp1;
        }
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{1, 2, 3, 4, 5});
        reorderList(head);

        Lists.printList(head);
    }
}

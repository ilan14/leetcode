package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 147. Insertion Sort List
 */
public class InsertionSortList {
    /**
     * 暴力求解
     * <p>
     * 时间复杂度 O(n^2)
     * 28 ms	38.9 MB
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummpyHead = new ListNode(0);

        ListNode cur = head;
        while (cur != null) {
            ListNode node = dummpyHead;
            while (node.next != null && node.next.val < cur.val) {
                node = node.next;
            }

            ListNode temp = cur.next;
            cur.next = node.next;
            node.next = cur;
            cur = temp;
        }

        return dummpyHead.next;
    }

    /**
     * 看了网上的解法后，在暴力解法上做了两处优化
     * 1. 假定原链表有序，只对违反顺序的节点进行插入排序  此优化后运行结果 4 ms 38.8 MB
     * 2. 在1的基础上，记录上一次插入查找的位置，进行比较，确定插入排序查找的起点
     * <p>
     * 3 ms	38.9 MB
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList1(ListNode head) {
        ListNode dummpyHead = new ListNode(0);
        dummpyHead.next = head;

        ListNode cur = head;
        ListNode mark = null;
        while (cur != null) {
            while (cur.next != null && cur.next.val >= cur.val) {
                cur = cur.next;
            }

            ListNode next = cur.next;
            if (next == null) {
                break;
            }

            ListNode node;
            if (mark != null && next.val >= mark.val) {
                node = mark;
            } else {
                node = dummpyHead;
            }
            while (node.next.val < next.val) {
                node = node.next;
            }

            mark = next;
            cur.next = next.next;
            next.next = node.next;
            node.next = next;
        }

        return dummpyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{1, 2, 2, 5, 8, 3, 4, 1, 9});

        head = insertionSortList1(head);

        Lists.printList(head);
    }

}

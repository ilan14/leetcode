package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 23. Merge k Sorted Lists
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        for (int i = lists.length / 2 - 1; i >= 0; i--) {
            heapify(lists, i, lists.length - 1);
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        int max = lists.length - 1;
        while (lists[0] != null) {
            cur.next = lists[0];
            cur = cur.next;
            lists[0] = lists[0].next;
            heapify(lists, 0, max);
            if (lists[max] == null) {
                max--;
            }
        }

        return head.next;
    }

    private void heapify(ListNode[] lists, int cur, int max) {
        int left = cur * 2 + 1;
        int right = left + 1;
        if (left > max) {
            return;
        }

        int target = cur;
        if (lists[left] != null && (lists[cur] == null || lists[left].val < lists[cur].val)) {
            target = left;
        }

        if (right <= max && lists[right] != null && (lists[target] == null || lists[right].val < lists[target].val)) {
            target = right;
        }

        if (target != cur) {
            ListNode temp = lists[cur];
            lists[cur] = lists[target];
            lists[target] = temp;
            heapify(lists, target, max);
        }
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode head = new MergekSortedLists().mergeKLists(lists);

        Lists.printList(head);
    }
}

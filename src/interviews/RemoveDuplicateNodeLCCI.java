package interviews;

import base.ListNode;
import base.Lists;

import java.util.HashSet;

/**
 * 面试题 02.01. Remove Duplicate Node LCCI
 */
public class RemoveDuplicateNodeLCCI {
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;

        HashSet<Integer> set = new HashSet<>();

        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.val)) {
                cur = cur.next;
                continue;
            }

            set.add(cur.val);

            ListNode temp = cur.next;
            node.next = cur;
            node = node.next;
            cur = temp;
        }

        node.next = null;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{1, 2, 3, 2, 1});

        head = removeDuplicateNodes(head);

        Lists.printList(head);
    }
//    public ListNode removeDuplicateNodes(ListNode head) {
//        ListNode dummyHead = new ListNode(0);
//
//        ListNode cur = dummyHead;
//        while (head != null) {
//            cur.next = head;
//            cur = cur.next;
//            head = head.next;
//            while (head != null && head.val == cur.val) {
//                head = head.next;
//            }
//        }
//
//        return dummyHead.next;
//    }
}

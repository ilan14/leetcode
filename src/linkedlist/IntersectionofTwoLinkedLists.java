package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 160. Intersection of Two Linked Lists
 */
public class IntersectionofTwoLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }

    public static void main(String[] args) {
        ListNode common = Lists.newLinkedList(new int[]{11, 13, 17, 19});

        ListNode headA = Lists.newLinkedList(new int[]{2, 3, 5, 7});

        ListNode headB = Lists.newLinkedList(new int[]{3, 7});

        ListNode tailA = headA;
        while (tailA.next != null) {
            tailA = tailA.next;
        }

        ListNode tailB = headB;
        while (tailB.next != null) {
            tailB = tailB.next;
        }

        tailA.next = common;
        tailB.next = common;

        ListNode node = getIntersectionNode(headA, headB);

        Lists.printList(node);
    }
}

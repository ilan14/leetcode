package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 206. Reverse Linked List
 */
public class ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode newHead = new ListNode(0);
		ListNode cur = head;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = newHead.next;
			newHead.next = cur;
			cur = temp;
		}

		return newHead.next;
	}

	public static ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode node = reverseList1(head.next);
		head.next.next = head;
		head.next = null;

		return node;
	}

	public static void main(String[] args) {
		ListNode head = Lists.newLinkedList(new int[]{1, 2, 3, 4, 5});

		ListNode node = reverseList(head);

		Lists.printList(node);

		ListNode head1 = Lists.newLinkedList(new int[]{2, 3, 5, 7, 11});

		ListNode node1 = reverseList(head1);

		Lists.printList(node1);
	}
}

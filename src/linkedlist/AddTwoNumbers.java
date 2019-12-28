package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode p = l1;
		ListNode q = l2;
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		int add = 0;
		while (p != null || q != null) {
			int a = p == null ? 0 : p.val;
			int b = q == null ? 0 : q.val;
			int num = a + b + add;
			add = num >= 10 ? 1 : 0;

			cur.next = new ListNode(num % 10);
			cur = cur.next;

			if (p != null) {
				p = p.next;
			}

			if (q != null) {
				q = q.next;
			}
		}

		if (add != 0) {
			cur.next = new ListNode(add);
		}

		return newHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = Lists.newLinkedList(new int[]{2, 4, 3});
		ListNode l2 = Lists.newLinkedList(new int[]{5, 6, 4});

		ListNode head = addTwoNumbers(l1, l2);

		Lists.printList(head);
	}
}

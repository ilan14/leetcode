package base;

import java.util.List;
import java.util.ListIterator;

public class Lists {
	public static ListNode newLinkedList(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}

		ListNode head = new ListNode(array[0]);
		ListNode cur = head;
		for (int i = 1; i < array.length; i++) {
			ListNode node = new ListNode(array[i]);
			cur.next = node;
			cur = cur.next;
		}

		return head;
	}

	public static void printList(ListNode head) {
		StringBuilder s = new StringBuilder();
		if (head == null) {
			s.append("null");
		} else {
			ListNode cur = head;
			while (cur != null) {
				s.append(cur.val).append(" -> ");
				cur = cur.next;
			}
			s.delete(s.length() - 4, s.length());
		}

		System.out.println(s.toString());
	}

	public static <E> void printList(List<E> list) {
		String str = toString(list);
		System.out.println(str);
	}

	public static <E> String toString(List<E> list) {
		if (list == null) {
			return "null";
		}

		if (list.isEmpty()) {
			return "[]";
		}

		StringBuilder s = new StringBuilder("[");
		ListIterator<E> it = list.listIterator();
		while (it.hasNext()) {
			s.append(it.next());
			if (it.hasNext()) {
				s.append(", ");
			}
		}
		s.append("]");

		return s.toString();
	}
}

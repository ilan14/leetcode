package linkedlist;

import base.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 445. Add Two Numbers II
 */
public class AddTwoNumbersII {
    /**
     * 用栈反转
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        Deque<Integer> stack1 = toStack(l1);
        Deque<Integer> stack2 = toStack(l2);
        ListNode head = new ListNode(0);
        int add = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int value = a + b + add;

            if (value >= 10) {
                value = value % 10;
                add = 1;
            } else {
                add = 0;
            }

            ListNode node = new ListNode(value);
            node.next = head.next;
            head.next = node;
        }

        if (add != 0) {
            ListNode node = new ListNode(add);
            node.next = head.next;
            head.next = node;
        }

        return head.next;
    }

    private Deque<Integer> toStack(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        return stack;
    }

    /**
     * 递归实现，需要先对齐
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        int len1 = length(l1);
        int len2 = length(l2);

        ListNode head;
        if (len1 >= len2) {
            head = addTwoNumbers(l1, l2, len1 - len2);
        } else {
            head = addTwoNumbers(l2, l1, len2 - len1);
        }

        if (head.val >= 10) {
            head.val = head.val % 10;
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }

        return head;
    }

    private int length(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }

        return i;
    }

    private ListNode addTwoNumbers(ListNode longer, ListNode shorter, int n) {
        if (longer.next == null && shorter.next == null) {
            return new ListNode(longer.val + shorter.val);
        }

        ListNode node;
        if (n > 0) {
            node = addTwoNumbers(longer.next, shorter, n - 1);
        } else {
            node = addTwoNumbers(longer.next, shorter.next, n);
        }

        int carry = 0;
        if (node.val >= 10) {
            node.val = node.val % 10;
            carry = 1;
        }

        ListNode cur;
        if (n > 0) {
            cur = new ListNode(longer.val + carry);
        } else {
            cur = new ListNode(longer.val + shorter.val + carry);
        }
        cur.next = node;

        return cur;
    }
}

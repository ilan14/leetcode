package linkedlist;

import base.ListNode;

/**
 * 234. Palindrome Linked List
 */
public class PalindromeLinkedList {
    /**
     * 1 ms	41.2 MB
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode dummpyHead = new ListNode(0);
        ListNode cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dummpyHead.next;
            dummpyHead.next = cur;
            cur = temp;
        }

        fast = head;
        slow = dummpyHead.next;
        while (fast != null && slow != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow = slow.next;
            } else {
                return false;
            }
        }

        return true;
    }
}

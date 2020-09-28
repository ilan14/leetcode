package linkedlist;

import base.ListNode;

import java.util.HashSet;

/**
 * 142. Linked List Cycle II
 */
public class LinkedListCycleII {
    /**
     * 6 ms	40 MB
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;

        HashSet<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }

            set.add(cur);
            cur = cur.next;
        }

        return null;
    }

    /**
     * 0 ms	39.2 MB
     *
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        }

        return null;
    }
}

package linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 */
public class FlattenaMultilevelDoublyLinkedList {
    /**
     * 0 ms	36.8 MB
     *
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node dummyHead = new Node();
        Node cur = dummyHead;

        Deque<Node> stack = new LinkedList<>();

        while (head != null) {
            if (head.next != null) {
                stack.push(head.next);
            }

            head.next = cur.next;
            cur.next = head;
            head.prev = cur;
            cur = cur.next;

            if (head.child != null) {
                Node child = head.child;
                head.child = null;
                head = child;
            } else if (!stack.isEmpty()) {
                head = stack.pop();
            } else {
                break;
            }
        }

        dummyHead.next.prev = null;

        return dummyHead.next;
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}

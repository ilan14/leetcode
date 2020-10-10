package linkedlist;

import java.util.HashMap;

/**
 * 138. Copy List with Random Pointer
 */
public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = map.computeIfAbsent(head, k -> new Node(head.val));
        Node tail = newHead;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            if (cur.next != null) {
                tail.next = map.computeIfAbsent(next, k -> new Node(next.val));
            }

            Node random = cur.random;
            if (random != null) {
                tail.random = map.computeIfAbsent(random, k -> new Node(random.val));
            }
            cur = cur.next;
            tail = tail.next;
        }

        return newHead;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}



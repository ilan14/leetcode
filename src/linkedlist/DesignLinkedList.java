package linkedlist;

import base.ListNode;
import base.Lists;

/**
 * 707. Design Linked List
 */
public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 10);
        myLinkedList.addAtIndex(0, 20);
        myLinkedList.addAtIndex(1, 30);

        myLinkedList.print();

        int val = myLinkedList.get(1);

        System.out.println(val);

        myLinkedList.deleteAtIndex(1);

        myLinkedList.print();

        val = myLinkedList.get(1);

        System.out.println(val);
    }
}

class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }

        if (index == length - 1) {
            return tail.val;
        }

        int i = 0;
        ListNode cur = head;
        while (i < index) {
            cur = cur.next;
            i++;
        }

        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        length++;

        if (length == 1) {
            tail = head;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (length == 0) {
            head = new ListNode(val);
            tail = head;
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < -1 || index > length) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == length) {
            addAtTail(val);
            return;
        }

        int i = 0;
        ListNode cur = head;
        while (i < index - 1) {
            cur = cur.next;
            i++;
        }

        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;

        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < -1 || index >= length) {
            return;
        }

        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            ListNode cur = head;
            int i = 0;
            while (i < index - 1) {
                cur = cur.next;
                i++;
            }

            cur.next = cur.next.next;

            if (index == length - 1) {
                tail = cur;
            }
        }

        length--;
    }

    public void print() {
        Lists.printList(head);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

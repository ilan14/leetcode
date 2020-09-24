package offer;

import base.ListNode;
import base.Lists;

import java.util.Arrays;

/**
 * 剑指 Offer 06. 从尾到头打印链表 LCOF
 */
public class ReversePrint {
    /**
     * 申请最大上限数组空间
     * 遍历并存储节点数据，并计算链表长度
     * 对数组0～length-1的位置从头尾进行交换，得到逆序
     * 复制0～length-1的数据到新数组
     * <p>
     * 假设链表长度为n，实际上遍历了 n + n/2 + n次
     * <p>
     * 1 ms	39 MB
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        int[] array = new int[10000];
        int length = 0;
        while (head != null) {
            array[length] = head.val;
            length++;
            head = head.next;
        }

        for (int i = 0; i < length / 2; i++) {
            int target = length - 1 - i;
            int temp = array[target];
            array[target] = array[i];
            array[i] = temp;
        }

        int[] result = new int[length];
        System.arraycopy(array, 0, result, 0, length);

        return result;
    }

    /**
     * 首先遍历链表，计算链表长度length
     * <p>
     * 申请length数组空间，递归到链表尾部，从尾节点到头节点逆序填充节点值到数组，每次返回当前填充的数组位置
     * <p>
     * 实际上遍历了 n + n 次，但递归耗费了额外空间
     * <p>
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 39.8 MB, 在所有 Java 提交中击败了13.48%的用户
     * <p>
     * 0 ms	39.8 MB
     *
     * @param head
     * @return
     */
    public static int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        int[] array = new int[length];

        reversePrint(head, array);

        return array;
    }

    private static int reversePrint(ListNode head, int[] array) {
        if (head == null) {
            return -1;
        }

        int pos = reversePrint(head.next, array) + 1;
        array[pos] = head.val;

        return pos;
    }

    /**
     * 网上看到的
     * <p>
     * 上面解法，得到链表长度后，实际上是可以确定每个节点对应的数组位置，不需要递归
     * 在上面基础上减少了空间复杂度
     * 时间 O(n) 空间 O(1)
     * <p>
     * 0 ms, 39.2 MB
     *
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        int[] array = new int[length];
        cur = head;
        while (cur != null) {
            array[length - 1] = cur.val;
            length--;
            cur = cur.next;
        }

        return array;
    }

    public static void main(String[] args) {
        ListNode head = Lists.newLinkedList(new int[]{1, 2, 3, 4, 5});

        int[] array = reversePrint1(head);

        System.out.println(Arrays.toString(array));
    }
}

package com.isea.dw.linkedlist;

/**
 * 翻转单向链表，时间复杂度为O（N），空间复杂度是O（1）
 */
public class ReverseSingleList {
    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node reverseSingleList(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
}

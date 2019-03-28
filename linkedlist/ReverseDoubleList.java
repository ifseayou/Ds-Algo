package com.isea.dw.linkedlist;

/**
 * 翻转双向链表
 */
public class ReverseDoubleList {
    public class Node{
        private int data;
        private Node pre;
        private Node next;

        public Node(int data){
            this.data = data;
            pre = next = null;
        }
    }

}

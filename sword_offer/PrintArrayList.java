package com.isea.dw.sword_offer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintArrayList {

    public static class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public static void printArrayList(Node node) {
        StringBuilder res = new StringBuilder();
        while (node.next != null) {
            res.append(node.data + "->");
            node = node.next;
        }
        res.append("NULL");
        System.out.println(res.toString());
    }


    public static void main(String[] args) {

        Node<Integer> node1 = new Node<Integer>(10);
        node1.next = new Node(20);
        node1.next.next = new Node(30);
        node1.next.next.next = new Node(40);
        printArrayList(node1);
    }
}

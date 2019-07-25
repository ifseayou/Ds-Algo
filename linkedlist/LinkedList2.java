package com.isea.dw.linkedlist;

/**
 * 手动实现一个LinkedList，要求满足如下的功能：
 * <p>
 * 向链表的任意一个位置添加元素
 * 向链表的头部添加元素，向链表的尾部添加元素
 * 删除链表的头部，尾部，任意位置的元素
 * 随机获取元素的值，传入index，获取链表的最后一个元素，或者是第一个元素
 * <p>
 * 查找链表中是否包含元素t
 * 判断链表是否为空
 * 判断链表的长度是多大
 * <p>
 * 技巧：使用虚拟头结点，这样能够在配合size，对链表删除和添加都不需要考虑特殊的情况。
 */
public class LinkedList2<T> {
    private class Node {
        private T val;
        private Node next;

        public Node() {
        }

        public Node(T val) {
            this();
            this.val = val;
        }

        public Node(T val, Node next) {
            this(val);
            this.next = next;
        }

        @Override
        public String toString() {
            return this.val.toString();
        }
    }

    // 为链表创建虚拟头结点
    private Node dummyHead;
    private int size; // 表征链表的长度信息

    public LinkedList2() { // 初始化链表，size 为零，虚拟头结点是的val值是为null的
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 返回链表的长度
    public int getSize() {
        return size;
    }

    // 判断链表是否是null
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取index位置的元素
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index...");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    // 获取表头
    public T getFirst() {
        return get(0);
    }

    // 获取链表的尾部元素
    public T getLast() {
        return get(size - 1);
    }

    // 在链表的index位置添加元素
    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index...");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(t, pre.next);
        size++;
    }

    // 在表头添加元素
    public void addFirst(T t) {
        add(0, t);
    }

    // 在表尾添加元素
    public void addLast(T t) {
        add(0, t);
    }

    // 删除链表index位置的元素
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index...");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node res = pre.next;
        pre.next = res.next;
        res.next = null;
        size--;

        return res.val;
    }

    // 删除链表头部元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除链表的尾部的元素
    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NUll");

        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList2<Integer> linkedList = new LinkedList2<>();
        for (int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}

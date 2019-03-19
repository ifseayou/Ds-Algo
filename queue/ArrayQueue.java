package com.isea.dw.queue;

/**
 * 使用固定数组实现队列，包括如下的操作
 * push 入队
 * pop 出队列
 * peek 查看一下队首的元素
 */
public class ArrayQueue<T> {
    private int[] queue;
    private int start; // 出队的时候元素的索引
    private int tail; // 入队的时候元素房放置的索引
    private int size; //目前队列中元素的个数

    public ArrayQueue(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Illegal args ...");
        }
        queue = new int[initialSize];
        start = 0;
        tail = 0;
        size = 0;
    }

    // 向队列中添加元素
    public void push(int target) {
        if (size == queue.length) {
            throw new IllegalArgumentException("The queue is full...");
        }
        queue[tail] = target;
        tail = (tail + 1) % queue.length;
        size++;
    }

    // 出队
    public int pop() {
        if (size == 0) {
            throw new IllegalArgumentException("The queue is empty...");
        }

        int res = queue[start];
        start = (start + 1) % queue.length;
        size--;
        return res;
    }

    // 看一下队首的元素
    public int peek() {
        if (size == 0) {
            throw new IllegalArgumentException("The queue is empty...");
        }
        return queue[start];
    }


}

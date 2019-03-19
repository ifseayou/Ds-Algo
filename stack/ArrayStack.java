package com.isea.dw.stack;

/**
 * 使用固定数组来实现栈，主要实现的操作是：
 * push ：入栈
 * pop ： 出栈
 * peek ： 查看栈顶的元素
 */
public class ArrayStack {
    private int stack[];
    private int index; // 下一次入栈的时候元素放置位置的索引

    public ArrayStack(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Illegal args...");
        }
        stack = new int[initialSize];
        index = 0;
    }


    // 向栈中添加元素
    public void push(int target) {
        if (index == stack.length) {
            throw new IllegalArgumentException("Stack has full...");
        }
        stack[index] = target;
        index++;
    }

    // 出栈
    public int pop() {
        if (index == 0) {
            throw new IllegalArgumentException("Stack is empty...");
        }

        return stack[--index];
    }

    // 查看栈顶的元素
    public int peek() {
        if (index == 0) {
            throw new IllegalArgumentException("Stack is empty...");
        }

        return stack[index - 1];
    }
}

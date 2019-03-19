package com.isea.dw.queue;


import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Stack2Queue {

    private static Stack<Integer> stack = new Stack();
    private static Stack<Integer> helpStack = new Stack();

    public static void push(int n) {
        stack.push(n);
    }

    public static Integer pop() {
        transfer();
        if (helpStack.isEmpty()) {
            return null; // 表示队列中没有元素
        }
        return helpStack.pop();
    }

    private static void transfer() {
        if (helpStack.isEmpty()) {
            while (!stack.isEmpty()) {
                helpStack.push(stack.pop());
            }
        }
    }
}



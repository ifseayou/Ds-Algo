package com.isea.dw.stack;

import java.util.Stack;

/**
 * 实现一个栈，满足入栈和出栈，并且能够在O（1）时间复杂度内获取栈中最小的元素
 */
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack();
        stackMin = new Stack();
    }

    public void push(int target) {
        stackData.push(target);
        if (stackMin.isEmpty()) {
            stackMin.push(target);
        } else {
            if (target >= stackMin.peek()) {
                stackMin.add(stackMin.peek());
            } else {
                stackMin.add(target);
            }
        }
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new IllegalArgumentException("The stack is empty...");
        }

        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new IllegalArgumentException("The stack is empty...");
        }
        return stackMin.peek();
    }
}

package com.isea.dw.windows;

import java.util.LinkedList;

/**
 * 生成窗口的最大值数组
 * 假设窗口的大小是3，给定一个数组，求该数组在窗口滑动的时候，形成的最大值构成的数组
 *
 * 思路：使用一个双向链表， 遍历整个数组，如果当前元素比链表尾部的值要大或者相等，就弹出链表中的值，然后把当前元素加入到链表中，
 * 如果当前元素比链表尾部的元素小，直接加入链表，如果窗口的大小有限制，还要判断链表头部的元素是否失效。
 */
public class MaxWindows {
    public static int[] getMaxWindows(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            // 如果当前元素大于或者等于链尾的元素，那么就弹出链尾的元素
            while (!qmax.isEmpty() && qmax.peekLast() <= arr[i]) {
                qmax.pollLast();
            }
            // 将当前元素添加到链表中
            qmax.addLast(i);

            // 判断链表头部的元素有没有过期，如果过期就直接弹出去
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }

            // 在形成窗口的情况下，将元素添加到结果数组中去
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] res = getMaxWindows(arr,3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

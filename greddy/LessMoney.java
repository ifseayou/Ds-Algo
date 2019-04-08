package com.isea.dw.greddy;

import java.util.PriorityQueue;

/**
 * 给定数组[10,20,30]，表示三个人要求的金条的长度，有个金条长度60，如果将60拆分为30 + 30 ，然后在将一个30拆分为10 + 20，花费 90
 * 如果先拆分为 10 + 50 ，20+30 花费110，怎么才分花费最小。
 * <p>
 * 标准的霍夫曼编码问题
 */
public class LessMoney {
    public static int lessMoney(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : arr) {
            minHeap.add(i);
        }

        int sum = 0;
        int cur = 0;
        while (minHeap.size() > 1) {
            cur = minHeap.poll() + minHeap.poll();
            sum += cur;
            minHeap.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(lessMoney(arr)); // 90
    }
}

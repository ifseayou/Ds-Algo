package com.isea.dw.recursion;

// 走台阶问题
public class StepNums {

    // 方法一：暴力递归
    public static int stepNum1(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return stepNum1(n - 1) + stepNum1(n - 2);
    }

    // 方法二：动态规划，数据归纳
    public static long stepNums2(int n) {
        long[] ints = new long[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];

    }

    public static void main(String[] args) {
        System.out.println(stepNum1(10));
        System.out.println(stepNums2(10));
    }

}

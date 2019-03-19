package com.isea.dw.leetcode;

import java.util.HashSet;

/**
 * LeetCode-349
 * 合并两个数组，同一元素只能返回一次
 */
public class InteractionArray {
    public static int[] merge(int[] arr1, int[] arr2) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            hashSet.add(arr1[i]);
        }

        HashSet<Integer> resSet = new HashSet<Integer>();

        for (int i = 0; i < arr2.length; i++) {
            if (hashSet.contains(arr2[i])) {
                resSet.add(arr2[i]);
            }
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        for (Integer integer : resSet) {
            res[i] = integer;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};

        int[] res = merge(num1, num2);

        for (int i = 0; i < res.length; i++) {
            System.out.print(" " + res[i]);
        }
    }
}
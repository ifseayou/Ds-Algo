package com.isea.dw.checker;

import java.util.Arrays;

// 排序对数器实现：主要功能是检验排序算法的正误
public class OrderChecker {

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    /**
     * 判断数组中的元素是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;

    }

    /**
     * 对数器：这是一个绝对正确的方法
     *
     * @param arr2
     */
    public static void comparator(int[] arr2) {
        Arrays.sort(arr2);
    }

    /**
     * 数组的完全拷贝
     *
     * @param arr1
     * @return
     */
    public static int[] copyArray(int[] arr1) {
        if (arr1 == null) {
            return null;
        }
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }

    /**
     * 随机数组产生器，数组的长度在maxSize内随机，
     * 数组的值在-maxValue到maxValue之间随机
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }
}

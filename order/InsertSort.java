package com.isea.dw.order;

import static com.isea.dw.checker.OrderChecker.*;
import static com.isea.dw.checker.OrderChecker.generateRandomArray;
import static com.isea.dw.checker.OrderChecker.printArray;

// 插入排序实现
public class InsertSort {
    public static void inertSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            inertSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {//若两个数组不相等
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "This is a right algorithm..." : "That is a wrong algorithm...");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        inertSort(arr);
        printArray(arr);
    }
}

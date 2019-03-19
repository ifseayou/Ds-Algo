package com.isea.dw.order;

import static com.isea.dw.checker.OrderChecker.*;

// 冒泡排序的实现
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int end = arr.length - 1; end > 0; end--) {
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {//若两个数组不相等
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "This is a right algorithm..." : "That is a wrong algorithm...");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}

package com.isea.dw.order;

import static com.isea.dw.checker.OrderChecker.*;
import static com.isea.dw.checker.OrderChecker.generateRandomArray;
import static com.isea.dw.checker.OrderChecker.printArray;

// 归并排序实现
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int middle = L + (R - L) / 2;
        sortProcess(arr, L, middle);
        sortProcess(arr, middle + 1, R);
        merge(arr, L, middle, R);
    }

    private static void merge(int[] arr, int L, int middle, int R) {
        int[] help = new int[R - L + 1];
        int p = L;
        int q = middle + 1;

        int i = 0;
        while (p <= middle && q <= R) {
            help[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
        }

        while (p <= middle) {
            help[i++] = arr[p++];
        }

        while (q <= R) {
            help[i++] = arr[q++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {//若两个数组不相等
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "This is a right algorithm..." : "That is a wrong algorithm...");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
}

package com.isea.dw.order;

import java.util.Random;

import static com.isea.dw.checker.OrderChecker.*;
import static com.isea.dw.checker.OrderChecker.generateRandomArray;
import static com.isea.dw.checker.OrderChecker.printArray;

// 随机快排的实现
public class QuickSort {
    public static void main(String[] args) {
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {//若两个数组不相等
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "This is a right algorithm...." : "That is a wrong algorithm...");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }

    public static void quickSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, (L + new Random().nextInt(R - L + 1)), R);
            int[] p = partition(arr, L, R);
            sortProcess(arr, L, p[0] - 1);
            sortProcess(arr, p[1] + 1, R);
        }

    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }

        }
        swap(arr, R, more);
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

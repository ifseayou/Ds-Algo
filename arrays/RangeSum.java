package com.isea.dw.arrays;

/**
 * LeetCode-303 求数组范围内i~j范围内的和
 */
public class RangeSum {

    public static int rangeSum(int[] arr, int i, int j) {
        if (arr == null || arr.length - 1 < j || i < 0) {
            throw new IllegalArgumentException("  ....");
        }
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(rangeSum(arr, 0, 2));

    }
}


class NumArray {

    private int sum[]; // sum[i] 表示的是数组中index = i之前的所有数字的和

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        this.sum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
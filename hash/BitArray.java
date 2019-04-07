package com.isea.dw.hash;

/**
 * 位图，使用位图可以实现布隆过滤器
 *
 * 下面实现如何将一个位图的某个特定的位置描黑
 */
public class BitArray {
    public static void main(String[] args) {
        int[] arr = new int[1000]; // 32000个比特位，这里可以理解为将32000个比特位分成了1000组，每组32个

        // 将第3000个比特位描黑
        int index = 3000;

        int intIndex = 3000 / index; // 获取组号
        int bitIndex = 3000 % index; // 获取组内的第几位

        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));
    }
}

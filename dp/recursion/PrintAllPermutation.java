package com.isea.dw.dp.recursion;

/**
 * 打印字符串的全排列
 *
 * 解决，网上的解法，然而我并没有怎么想明白
 */
public class PrintAllPermutation {
    public static void printAllPermutation(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            printAllPermutation(chs, i + 1);
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
    public static void main(String[] args) {
        printAllPermutation("abc".toCharArray(),0);
    }
}

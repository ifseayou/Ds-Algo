package com.isea.dw.dp.recursion;

/**
 * 求n的阶乘
 */
public class NFactorial {

    public static int getFactorial(int n){
        if (n == 1){
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(4));
    }
}

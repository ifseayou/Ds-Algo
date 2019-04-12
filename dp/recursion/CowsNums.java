package com.isea.dw.dp.recursion;

/**
 * 母牛每年生一只母牛，新出生的母牛成长三年后，也能生育一只母牛，假设牛不会死，求N年之后，母牛的数量
 *
 * f(N) = f(N-1) + f(N - 3) : 今年的母牛的数量 = 去年母牛的数量 + 三年前的成熟母牛在今年生育的母牛
 */
public class CowsNums {
    public static int cowsNums(int n){
        if (n == 1 || n == 2 || n == 3){
            return n;
        }
        return cowsNums(n - 1) + cowsNums(n - 3);
    }
    public static void main(String[] args) {
        System.out.println(cowsNums(7));
    }
}

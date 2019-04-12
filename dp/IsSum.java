package com.isea.dw.dp;

/**
 * 给定一个数组arr，和得到一个整数aim，如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者是false
 */
public class IsSum {

    /**
     * @param sum   index位置之前的元素形成的和
     * @param index 来到的当前的index位置
     * @param aim   目标元素的和
     */
    public static boolean isSum(int[] arr, int index, int sum, int aim) {
        if (arr.length == index) {
            return sum == aim;
        }
        return isSum(arr, index + 1, sum, aim) || isSum(arr, index + 1, sum + arr[index], aim);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(isSum(arr, 0, 0, 8)); // true
    }

    /*
        如何构建动态规划表？一共N行，默认所有的数据都是整数，将所有的数据相加最为列数，那么所有的数都会落在总和之内
        然后在去看一个任意的位置，
     */
}
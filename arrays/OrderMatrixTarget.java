package com.isea.dw.arrays;

/**
 * 一个二维数组，行从左到右是递增的，列从上到下递增，输入一个target，检查二维数组中
 * 是否有target
 */
public class OrderMatrixTarget {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {5, 7, 7, 9}};
        System.out.println(isContains(matrix, 6));
        System.out.println(isContains(matrix, 9));
    }

    // 从数组的左下角或者是右上角开始
    public static boolean isContains(int[][] matrix, int target) {
        // 定义当前位置（也是起始点）,
        int curR = matrix.length - 1;
        int curL = 0;
        while (curL <= matrix[0].length - 1 && curR >= 0) {
            if (matrix[curR][curL] < target) {
                curL++;
            } else if (matrix[curR][curL] > target) {
                curR--;
            } else { // target = matrix[curR][curL]
                return true;
            }
        }
        return false;
    }
}

package com.isea.dw.dp;

/**
 * 最小路径和的问题：
 * 给定一个矩阵，从左上角到右下角的路径和的最小值
 */
public class MinPathSum {
    public static int minPathSum(int[][] matrix, int i ,int j){
        if (i == matrix.length - 1 && j == matrix[0].length - 1){
            return matrix[i][j]; // 如果已经来到了矩阵的右下角
        }
        // 如果来到了矩阵的最后一行
        if (i == matrix.length - 1){
            return matrix[i][j] + minPathSum(matrix,i,j + 1);
        }
        // 如果来到了矩阵的最后一列
        if (j == matrix[0].length - 1){
            return matrix[i][j] + minPathSum(matrix,i + 1, j);
        }
        // 如果是矩阵的任意一个位置
        return matrix[i][j] + Math.min(minPathSum(matrix,i,j + 1),minPathSum(matrix,i + 1, j));
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 2, 1, 0},
                {7, 5, 0, 1},
                {3, 7, 6, 2}
        };
        System.out.println(minPathSum(matrix, 0, 0)); // 9
    }
}

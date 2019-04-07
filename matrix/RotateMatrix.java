package com.isea.dw.matrix;

/**
 * 将矩阵顺时针旋转90度
 */
public class RotateMatrix {
    public static void rotateMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("The matrix is null...");
        }
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a < c) {
            circle(matrix, a++, b++, c--, d--);
        }
    }

    // 每次旋转一圈
    private static void circle(int[][] matrix, int a, int b, int c, int d) {
        int times = d - b;
        int tmp = 0;
        for (int i = 0; i < times; i ++){
            tmp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b];
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("-----------");
        printMatrix(matrix);
    }
}

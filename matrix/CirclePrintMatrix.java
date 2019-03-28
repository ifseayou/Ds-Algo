package com.isea.dw.matrix;

/**
 * 转圈打印一个矩阵
 * 实现的思路： 如果矩阵退化是一个向量（行向量或者是列向量）那么直接for循环打印即可
 * 如果满足矩阵的条件，一层一层的打印，也即个循环打印 一圈，一圈的次序为：
 * 第一行->最后一列->最后一行->第一列，打印完成之后，左上角的左标加一，右下角的左表减一
 * 直到最后行和列都交叉停止
 */
public class CirclePrintMatrix {

    /**
     * 转圈打印一个矩阵
     * @param metric
     */
    public static void circlePrint(int[][] metric) {
        int a = 0;
        int b = 0;
        int c = metric.length - 1;
        int d = metric[0].length - 1;
        while (a <= c && b <= d) {
            circlePrint(metric, a++, b++, c--, d--);
        }
    }

    /**
     * 打印(a,b) -> (c,d) 从左上角到右下角的所有的元素
     *
     * @param metric
     * @param a
     * @param b
     * @param c
     * @param d
     */
    private static void circlePrint(int[][] metric, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.print(metric[a][i] + " ");
            }
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.print(metric[i][b]);
            }
        } else {
            int curC = b;
            int curR = a;
            while (curC != d) {
                System.out.print(metric[a][curC] + " ");
                curC++;
            }
            while (curR != c) {
                System.out.print(metric[curR][d] + " ");
                curR++;
            }
            while (curC != b) {
                System.out.print(metric[c][curC] + " ");
                curC--;
            }
            while (curR != a) {
                System.out.print(metric[curR][b] + " ");
                curR--;
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 5, 6, 5}, {44, 37, 76, 9, 4}, {77, 23, 8, 10, 33}, {4, 88, 7, 4, 3}};
        circlePrint(matrix); // 1 2 5 6 5 4 33 3 4 7 88 4 77 44 37 76 9 10 8 23
    }
}
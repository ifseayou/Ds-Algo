package com.isea.dw.trie_set;

/**
 * 现在有一个矩阵，矩阵中只有元素0 和元素1 ，连在一片的1 称之为一个岛，求一个矩阵中的到的个数;
 * <p>
 * 如果是一个巨大的矩阵，需要将该矩阵做一个map分解，分解之后计算岛的数量，然后在做reduce求出一共岛的数量
 * 此时需要收集分岛的边界信息，在做reduce的时候，根据边界信息是否属于同样的一个代表节点，来判断有多少个岛
 * 此时需要使用到并查集
 */
public class LandsNums {
    public static int lansNums(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    res++;
                    infect(matrix, i, j, M, N);
                }
            }
        }
        return res;
    }

    // 感染函数，如果遇到了1，就将其设置为2，并将和其连在一起的1都修改为2
    private static void infect(int[][] matrix, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] != 1) { // 这里要注意matrix[i][j] =0或者2的时候，需要stop感染
            return;
        }
        matrix[i][j] = 2;
        infect(matrix, i + 1, j, m, n);
        infect(matrix, i - 1, j, m, n);
        infect(matrix, i, j + 1, m, n);
        infect(matrix, i, j - 1, m, n);
    }

    public static void main(String[] args) {
        int[][] m = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 1, 0}
        };
        System.out.println(lansNums(m));// 2
    }
}

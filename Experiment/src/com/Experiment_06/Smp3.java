package com.Experiment_06;

import java.util.Arrays;

/*
    矩阵快速幂
 */
public class Smp3 {

    public static long[][] multiply(long[][] A, long[][] B) {
        long[][] res = new long[A.length][B.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }

    // k次幂，n*n的矩阵
    public static long[][] mut(int k, int n, long[][] A) {
        long[][] res = new long[n][n];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (i == j) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = 0;
                }
            }
        }
        while (k != 0) {
            if ((k & 1) == 1) res = multiply(res, A);
            k >>= 1;
            A = multiply(A, A);
        }
        return res;
    }

    public static void main(String[] args) {

        long[][] A = {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};
        long[][] res = mut(10, 3, A);
        System.out.println(Arrays.deepToString(res));
    }

}


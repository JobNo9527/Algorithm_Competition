package com.Experiment_05;

import java.util.Scanner;

public class Smp1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] a = new long[n];
        long[] b = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for (int k = 1; k < n; k++) {
            for (int j = 0; j < n - k; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swap(b, j, j + 1);
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (a[i + 1] > b[i])
                System.out.println(a[i] + " " + b[i]);
            else if (b[i + 1] >= b[i])
                a[i + 1] = a[i];
            else if (b[i + 1] < b[i]) {
                a[i + 1] = a[i];
                b[i + 1] = b[i];
            }
        }

        System.out.println(a[n - 1] + " " + b[n - 1]);
    }

    private static void swap(long[] a, int m, int n) {
        long t = a[m];
        a[m] = a[n];
        a[n] = t;
    }
}
/*
样本输入
5
5 6
1 4
10 10
6 9
8 10
样本输出
1 4
5 10
 */
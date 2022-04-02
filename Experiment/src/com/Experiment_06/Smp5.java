package com.Experiment_06;

import java.util.Scanner;

/*
    输出范围到n的素数
 */
public class Smp5 {

    public static void main(String[] args) {

        System.out.println("n?");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 范围从2开始到n的数组
        for (int i = 0; i < arr.length - 1; i++)
            arr[i] = i + 2;

        for (int i = 2; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] != 0) {
                    // 剔除所有不符合素数性质的数
                    if (arr[j] % i == 0 && arr[j] / i != 1) {
                        arr[j] = 0;
                    }
                }
            }
        }

        System.out.println("输出素数对：");

        int res = 0;
        for (int num : arr) {
            if (num != 0) {
                System.out.print(num + " ");
                res++;
                if (res % 2 == 0)
                    System.out.println();
            }
        }

        System.out.println();
        System.out.println("完成！共有：" + res + " 个");
    }
}

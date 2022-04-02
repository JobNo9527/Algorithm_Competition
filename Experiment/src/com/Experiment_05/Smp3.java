package com.Experiment_05;

import java.util.Arrays;
import java.util.Scanner;

public class Smp3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("有多少排奶牛？");
        int cas = sc.nextInt();
        for (int i = 0; i < cas; i++) {
            System.out.println("有多少头？");
            int n = sc.nextInt();
            Integer[] cows = new Integer[n];
            System.out.println("输入每一头牛的产量：");
            for (int j = 1; j <= n; j++)
                cows[j - 1] = sc.nextInt();

            sort(cows);
            System.out.println(Arrays.toString(cows));
            System.out.println("中间产量牛：" + cows[cows.length / 2]);
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            //选择arr[i..n)中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }

            swap(arr, i, minIndex);
        }
    }

    //交换
    private static <E> void swap(E[] arr, int i, int j) {

        //泛形
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

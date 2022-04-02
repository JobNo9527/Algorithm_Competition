package com.Experiment_05;

import java.util.Scanner;

public class Smp4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Smp4 s = new Smp4();
        int res = s.reversePairs(arr);
        if (res <= k)
            System.out.println("0");
        else
            System.out.println(res - k);
    }

    public int reversePairs(int[] nums) {

        int[] temp = new int[nums.length];
        return sort(nums, 0, nums.length - 1, temp);
    }

    // 返回逆序对个数
    private int sort(int[] arr, int l, int r, int[] temp) {

        //递归终点，遍历完没有了，就返回0
        if (l >= r) return 0;

        int res = 0;
        int mid = l + (r - l) / 2;
        res += sort(arr, l, mid, temp);
        res += sort(arr, mid + 1, r, temp);
        if (arr[mid] > arr[mid + 1]) {
            res += merge(arr, l, mid, r, temp);
        }
        return res;
    }

    private int merge(int[] arr, int l, int mid, int r, int[] temp) {

        System.arraycopy(arr, l, temp, l, r - l + 1);   //temp也已经从l开始了

        int i = l, j = mid + 1, res = 0;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                res += mid - i + 1;
                arr[k] = temp[j];
                j++;
            }
        }
        return res;
    }
}

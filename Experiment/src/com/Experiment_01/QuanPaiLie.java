package com.Experiment_01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 将晖
 */


public class QuanPaiLie {
    public static void main(String[] args) {

        System.out.println("输入想要全排列的数的个数：");
        Scanner sc1 = new Scanner(System.in);
        int len = sc1.nextInt();
        int[] array = new int[len];

        System.out.println("输入" + len + "个数的数组(回车输入下一个数)：");
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = sc2.nextInt();
        }
        System.out.println(Arrays.toString(array));
        bfs(array, 0, array.length - 1);
    }

    public static void bfs(int[] a, int start, int end) {
        /*
         * 递归的终点是，我们拿着start去逐个和后面的集合考虑要不要交换：
         * 当需要交换时，我们交换，start+1
         * 当不需要交换时，我们不交换，start还是要加1，因为我们要靠着start进入递归的最底层
         * 一直start比较到最后了，交不交换都反正都结束了，我们打印处结果。然后返回到递归的上一层。
         * 在上一层（我们的start后退一步），搜索是否应该和start交换的i也加1了。
         * 如处理{1，2，3}全排列
         * 相当于在处理完{2,3}的全排列后，
         * 我们回到上一层，start到了{1}，此时需要考虑将{1} 和{2，3}里面交换。i就是去寻找2,3的
         *
         *
         * */
        if (start == a.length) {
            for (int i : a) {
                System.out.print(i);
            }
            System.out.print(" ");
        }

        for (int i = start; i < a.length; i++) {
            if (isUnique(a, start, i)) {
                swap(a, start, i);
                bfs(a, start + 1, i);
                //返回数组原样，i为原来交换数的下表
                swap(a, start, i);
            }

        }
    }

    //检查数组中有无交换重复的数，如果存在，则返回false，不执行交换
    static boolean isUnique(int a[], int start, int end) {
        for (int i = start; i < end; i++) {
            if (a[i] == a[end]) {
                return false;
            }
        }
        return true;
    }


    public static void swap(int[] a, int m, int n) {
        int t = a[m];
        a[m] = a[n];
        a[n] = t;
    }
}

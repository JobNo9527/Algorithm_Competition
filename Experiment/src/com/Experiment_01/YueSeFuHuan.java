package com.Experiment_01;

import java.util.Scanner;

/**
 * @author 将晖
 */

/*
    每出局一人，就把剩余的所有人都往左移m位(这里的m是3)
    显然可以看出，无论什么情况下，最后好人（假定是三）所在的位置必定是0号位，
    那么他在上一轮(第6轮)的位置就是(0+3)%2=1。这里”+3”的含义就是右移，
    因为他是通过左移来到这轮的，要想返回到上一轮就得右移，
    但要考虑越界的情况所以要对n求余，n是该轮所剩人数。在第5轮的位置就是(1+3)%3=1，如此循环就能得出胜利者在刚开始的位置。
 */
public class YueSeFuHuan {
    public static void josephus(int n, int m) {
        int[] nums = new int[n + 1];
        int count = 1;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
            flag += i;
        }

        System.out.print("好人的序列是：");
        while (flag > 0) {
            for (int i = 1; i <= n; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                nums[i] = count;
                count++;
                if (nums[i] == m) {
                    System.out.printf(i + " ");
                    count = 1;
                    nums[i] = 0;    // 对该元素做标记，下次遍历时跳过该元素
                    flag -= i;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("输入总人数：");
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        System.out.println("输入步长：");
        Scanner sc2 = new Scanner(System.in);
        int m = sc2.nextInt();
        josephus(n, m);
    }
}


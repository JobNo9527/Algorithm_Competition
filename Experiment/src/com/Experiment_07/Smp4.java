package com.Experiment_07;

import java.util.Random;
import java.util.Scanner;

public class Smp4 {

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    public static int human(int n) {
        while (true) {
            System.out.println("Human picks:");
            int num = sc.nextInt();
            if (num < 1 || num > 3) {
                System.out.println("Pick illegal.");
                continue;
            }
            return n - num;
        }
    }

    public static int computer(int n) {
        if (n == 4)
            return 1;
        if (n == 3)
            return 2;
        if (n == 2)
            return 1;
        else
            return rnd.nextInt(3) + 1;
    }

    public static void main(String[] args) {

        System.out.println("输入豆子总数n:");
        int n = sc.nextInt();
        while (true) {
            int HP = human(n);
            int CP = computer(HP);
            n = HP - CP;
            if (HP == 1) {
                System.out.println("Human win!");
                break;
            }

            if (n <= 0) {
                System.out.println("至少要留一个豆子在堆内。");
                System.exit(0);
            } else
                System.out.printf("computer: %d, remain: %d\n", CP, n);

            if (n == 1) {
                System.out.println("Computer win!");
                break;
            }
        }
    }
}

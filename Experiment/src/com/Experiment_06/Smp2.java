package com.Experiment_06;

/*
    快速幂
 */
public class Smp2 {

    public static void main(String[] args) {

        int res = qPow(7, 1000);
        System.out.println("res: " + res);
    }

    // 递归求解
    public static int qPow(int a, int n) {

        if (n == 0)
            return 1;
        else if (n % 2 == 1)
            return qPow(a, n - 1) * a;
        else {
            int temp = qPow(a, n / 2);
            return temp * temp;
        }

    }
}

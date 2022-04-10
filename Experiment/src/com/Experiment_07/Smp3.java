package com.Experiment_07;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Smp3 {

    private static BigInteger four = BigInteger.valueOf(4);
    private static BigInteger two = BigInteger.valueOf(2);
    private static BigInteger[] ca = new BigInteger[1001];  // 给bigInteger数组开空间

    // 打印最多为第n个的卡特兰数
    public static void catalan(int n) {

        ca[0] = ca[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger nn = BigInteger.valueOf(i);
            BigInteger mm = (four.multiply(nn)).subtract(two);
            BigInteger ii = nn.add(BigInteger.ONE);
            ca[i] = (mm.multiply(ca[i - 1])).divide(ii);
        }
    }

    public static void main(String[] args) {
        // 采用缓冲输入流，保证用户一直输入一直有结果
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        catalan(1000);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            System.out.println(ca[n]);
        }
    }
}

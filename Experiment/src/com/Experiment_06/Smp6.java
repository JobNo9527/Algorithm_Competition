package com.Experiment_06;

import java.io.*;
import java.math.BigInteger;

/*
    矩阵快速幂求解斐波那契数
        {F(n+1) F(n)} = {1, 1}, {1, 0}^n * {F(1) F(0)}
 */
public class Smp6 {

    //BigInteger divide(BigInteger val) 返回值为 (this / val)的BigInteger。
    //BigInteger pow(int exponent) 返回值为 (this^exponent)的BigInteger。
    //BigInteger sqrt() 返回此BigInteger的整数平方根。
    //BigInteger subtract(BigInteger val) 返回值为 (this - val)的BigInteger。
    public static BigInteger fibonacci(int n) {

        BigInteger pow1 = BigInteger.ONE.add(new BigInteger("5")).divide(BigInteger.TWO).pow(n);
        BigInteger pow2 = BigInteger.ONE.subtract(new BigInteger("5")).divide(BigInteger.TWO).pow(n);
        BigInteger fibN = pow1.subtract(pow2);

        return fibN.divide(new BigInteger("5"));
    }

    public static void main(String[] args) throws IOException {

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("f.txt"));
        long startTime = System.nanoTime();
        o.writeObject(fibonacci(1_000_000_000).toString());
        o.close();
        long endTime = System.nanoTime();
        System.out.println("用时总计：" + (endTime - startTime) / 1000000000.0 / 60.0 + " minutes");
    }
}
/*
    用时总计：102.70176448333333 minutes
 */
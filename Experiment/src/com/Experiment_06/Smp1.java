package com.Experiment_06;

import java.math.BigInteger;
import java.util.Random;

/*
    大数运算
 */
public class Smp1 {

    public static void main(String[] args) {

        Random r = new Random();
        BigInteger b1 = new BigInteger("123456789");
        BigInteger b2 = new BigInteger("987654321");

        System.out.println("大数加法：" + b1.add(b2));
        System.out.println("大数乘法：" + b1.multiply(b2));
    }
}

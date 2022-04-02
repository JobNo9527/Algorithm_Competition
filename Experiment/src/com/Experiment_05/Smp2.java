package com.Experiment_05;

import java.util.Scanner;

/*
    模拟降火解决函数最值问题
 */
public class Smp2 {

    public static final int T = 100;// 初始化温度
    public static final double eps = 1e-8;// 温度的下界
    public static final double delta = 0.98;// 温度的下降率

    //产生一个0~100之间的随机double数
    public static double getX() {
        return Math.random() * 100;        //math.random默认产生一个[0.0~1.0]之间的数。
    }

    public static double getFuncResult(double x, double y) {
        return 6 * Math.pow(x, 7) + 8 * Math.pow(x, 6) + 7
                * Math.pow(x, 3) + 5 * Math.pow(x, 2) - x * y;
    }

    public static double getSA(int k, double x, double y) {
        //因为求函数的最小值，所以初始化为最大，同理，如果求函数最大值，初始化为最小值。
        double result = Double.MAX_VALUE;// 初始化最终的结果,64位双精度值能表示的最大正数
        double t = T;
        // 迭代的过程
        while (t > eps) {
            for (int i = 0; i < k; i++) {
                // 计算此时的函数结果
                double funTmp = getFuncResult(x, y);
                // 在邻域内产生新的解
                double newx = x + (Math.random() * 2 - 1) * t;
                // 判断新的x不能超出界
                if (newx >= 0 && newx <= 100) {
                    double funTmp_new = getFuncResult(newx, y);
                    //如果新的函数值比之前的函数值要小，则用新的x值替换原来的x值。否则，
                    if (funTmp_new - funTmp < 0) {
                        // 替换
                        x = newx;
                    } else {
                        // 以概率替换
                        double p = 1 / (1 + Math
                                .exp(-(funTmp_new - funTmp) / T));
                        if (Math.random() < p) {
                            x = newx;
                        }
                    }
                }
            }
            t = t * delta;
        }
        //结果与各个函数值作比较，得出最小值。
        for (int i = 0; i < k; i++) {
            result = Math.min(result, getFuncResult(x, y));
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double x = getX();

        System.out.println("输入迭代次数：");
        int k = sc.nextInt();
        System.out.println("输入y值：");
        double y = sc.nextDouble();
        System.out.println("最优解为：");
        System.out.println(getSA(k, x, y));
    }
}


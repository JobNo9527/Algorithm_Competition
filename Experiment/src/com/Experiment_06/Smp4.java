package com.Experiment_06;

import java.util.Scanner;

public class Smp4 {

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    int res = 1;

    public void find(long x, long y) {
        if (y > x) {
            long t = x;
            x = y;
            y = t;
        }
        long g = gcd(x, y);
        long tt = x * g / (g + y);
        if ((g + y) != 0 && (x * g % (g + y) == 0) && (gcd(tt, y) == gcd(x, y))) {
            res++;
            long t = x * g / (g + y);
            find(x * g / (g + y), y);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long x, y;
        x = sc.nextLong();
        y = sc.nextLong();
        Smp4 s = new Smp4();
        s.find(x, y);
    }
}

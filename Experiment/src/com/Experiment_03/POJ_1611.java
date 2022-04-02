package com.Experiment_03;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class POJ_1611 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        while (sc.hasNext()) {
            int n = sc.nextInt();   //总人数
            int m = sc.nextInt();   //社团数

            if (n == 0 && m == 0)
                break;

            UnionSet unionSet = new UnionSet(n);

            // 遍历储存社团社长跟他的小弟
            for (int i = 0; i < m; i++) {
                int k = sc.nextInt();   //有k个人的社团
                int root = sc.nextInt();
                for (int j = 0; j < k - 1; j++) { //k-1个
                    int x = sc.nextInt();
                    unionSet.union(root, x); //这个集合的根
                }
            }

            int sum = 1; //0号已经被嫌疑
            for (int i = 1; i < n; i++) {
                if (unionSet.isSameSet(0, i)) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }

    // 并查集
    static class UnionSet {

        private int[] s;
        private int[] height;

        public UnionSet(int size) {
            s = new int[size];
            height = new int[size];

            for (int i = 0; i < size; i++) {
                s[i] = i;
                height[i] = 0;
            }
        }

        public int size() {
            return s.length;
        }

        public int find(int x) {
            if (x < 0 || x >= s.length)
                throw new IllegalArgumentException("x is out of bound");

            while (x != s[x]) {
                // 将x 设置为他的老大的老大
                s[x] = s[s[x]];
                x = s[x];
            }

            // x就是老大本身
            return x;
        }

        public void union(int x, int y) {

            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot == yRoot) {
                return;
            }

            if (height[xRoot] > height[yRoot])
                s[yRoot] = xRoot;
            else if (height[xRoot] < height[yRoot])
                s[xRoot] = yRoot;
            else
                s[xRoot] = yRoot;
            height[yRoot]++;
        }

        // 找到同一个集的组
        public boolean isSameSet(Integer a, Integer b) {
            return find(b) == find(a);
        }
    }
}

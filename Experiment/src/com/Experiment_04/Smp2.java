package com.Experiment_04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Smp2 {

    //lson l,m,rt<<1
    //rsom m+1,r,rt<<1|1
    private static int[] sum;
    private static int[] te;
    private static int total;   //默认初值是0

    public static void push_up(int rt) {
        // 更新当前的人数给父节点
        sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
    }

    public static void build(int l, int r, int rt) {
        if (l == r) {
            sum[rt] = te[total++]; //到只有一个节点的时候，
            return;
        }

        int mid = (l + r) >> 1;
        build(l, mid, rt << 1); //创建左边的线段树
        build(mid + 1, r, rt << 1 | 1); //创建右边的线段树并统计rt当前节点的值（就是这个营地有多少人）
        push_up(rt);
    }

    // Add & Sub
    public static void update(int p, int add, int l, int r, int rt) {

        if (l == r) {
            sum[rt] += add;
            return;
        }

        int mid = (l + r) >> 1;
        if (p <= mid)
            update(p, add, l, mid, rt << 1);
        else
            update(p, add, mid + 1, r, rt << 1 | 1);

        push_up(rt);
    }

    public static int query(int L, int R, int l, int r, int rt) {

        if (L <= l && r <= R) {
            return sum[rt]; //往下探到达终点时，返回这个阵营的人数
        }

        int mid = (l + r) >> 1;
        int ret = 0;    //返回该阵营的人数
        if (L <= mid) { //[l,L]
            ret += query(L, R, l, mid, rt << 1);
        }
        if (R > mid) {  //[R,r]
            ret += query(L, R, mid + 1, r, rt << 1 | 1);
        }

        // 返回该从[L,R]阵营的人数
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());    // 设置任务次数，1就是侦查任务1

        for (int i = 1; i <= t; ++i) {
            System.out.println("Case " + i + ":");
            int n = Integer.parseInt(br.readLine());    //阵营数
            te = new int[n + 1]; //
            sum = new int[n << 2];    //给sum数组扩容两倍
            total = 1;

            String[] temp = br.readLine().split("\\s+");    // 空格分开依次存入temp[],存入每个阵营的人数
            // 1 2 3 4 5 6 7 8 9 10 就是一个一个阵营的人数，当前总人数为55
            for (int j = 1; j <= n; ++j) {
                te[j] = Integer.parseInt(temp[j - 1]);
            }
            build(1, n, 1);

            while (true) {
                temp = br.readLine().split("\\s+");
                String s = temp[0]; // 任务类型：Q->在哪个阵营，增加了多少人 S->在哪个阵营，减少了多少人

                if (s.charAt(0) == 'E') {
                    break;
                }

                int a = Integer.parseInt(temp[1]);  //第几个阵营
                int b = Integer.parseInt(temp[2]);  //加多少人，减多少人

                if (s.charAt(0) == 'A') {
                    update(a, b, 1, n, 1);
                }

                if (s.charAt(0) == 'S') {
                    update(a, -b, 1, n, 1);
                }

                if (s.charAt(0) == 'Q') {
                    System.out.println(query(a, b, 1, n, 1));
                }
            }
        }

    }
}


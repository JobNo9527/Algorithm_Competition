package com.Experiment_02;

/**
 * @author 将晖
 */


public class Queen8 {

    // 一共有多少个皇后（此时设置为8皇后在8X8棋盘）
    static int max = 8;
    // 该数组保存结果，第一个皇后摆在array[0]列，第二个摆在array[1]列
    static int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {

        //Queen8 queen8 = new Queen8();
        //queen8.check(0);
        check(0);
        System.out.println("一共有" + count + "种解法");
    }

    /**
     * n代表当前是第几个皇后 [n 是从 0 开始算的，即0 表示第一个皇后, 同时n也表示第几行]
     * 即 第1行是第一个皇后(n=0)，第2行是第二个皇后(n=1), 第8行是第8个皇后(n=7)，如果遍历到第9行(n=8)，说明
     * 皇后全部放置好了, 就相应的得到了一种解法...
     * 然后回溯 ，又将第一个皇后，放置第1行的第2列...
     *
     * @param n 皇后n在array[n]列
     */
    private static void check(int n) {
        //终止条件是最后一行已经摆完，
        //由于每摆一步都会校验是否有冲突，
        //所以只要最后一行摆完，说明已经得到了一个正确解
        if (n == max) {
            print();
            return;
        }
        //将第n个皇后从.第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
        for (int i = 0; i < max; i++) {
            array[n] = i; //先将第一个皇后放置第一行的第一列 array[0] = 0
            if (judge(n)) {  // 如果 该皇后没有和其它皇后冲突
                check(n + 1); // 放第二个皇后，因为是递归，因此大家可以思考，第二个皇后是从 第二行的第1列开始放
            }
        }
    }

    /**
     * 查看n皇后是否满足约束条件(即：检查皇后n是否会发生冲突)
     * 如果冲突，返回 false , 如果不冲突返回true
     * 0 4 7 5 2 6 1 3
     *
     * @param n
     * @return
     */
    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //说明:
            //1. array[i] == array[n] 判断 是不是在同一列
            //2. Math.abs(n - i) == Math.abs(array[n] - array[i]) 判断是不是在同一条斜线
            //3. 不用判断是不是在同一行，因为我们每放一个皇后，行是递增的.
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印这个满足条件的八皇后的放置位置
     */
    private static void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

package com.Experiment_02;

/**
 * @author 将晖
 */


public class AddThePentagram {
    /**
     * 考察全排列,递归
     *
     */
    static int[] numArr;
    static int count = 0;

    public static void main(String[] args) {
        numArr = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 12};
        int result = f(numArr, 0);
        System.out.println("方案有：" + result / (5 * 2));// 因为是五角星，所以每个角都有两个对称，所以除以(5*2)
    }

    /**
     * 对数组进行全排列，计算所有可能结果
     *
     * @param numArr 数组
     * @param i      开始排列位置
     * @return 所有可能结果
     */
    private static int f(int[] numArr, int i) {

        // 递归出口
        if (i == 10) {
            if (check()) {
                count++;
            }
        }
        // 全排列，递归
        for (int j = i; j < numArr.length; j++) {
            int temp = numArr[i];
            numArr[i] = numArr[j];
            numArr[j] = temp;

            f(numArr, i + 1);

            // 回溯
            temp = numArr[i];
            numArr[i] = numArr[j];
            numArr[j] = temp;
        }
        return count;
    }

    /**
     * 判断五角星每条边的和是否相等
     *
     * @return true 相等;false 不相等
     */
    private static boolean check() {
        int a1 = numArr[0] + numArr[2] + numArr[5] + numArr[8];
        int a2 = numArr[0] + numArr[3] + numArr[6] + numArr[9];
        int a3 = numArr[1] + numArr[2] + numArr[3] + numArr[4];
        int a4 = numArr[1] + numArr[5] + numArr[7] + numArr[9];
        int a5 = numArr[4] + numArr[6] + numArr[7] + numArr[8];
        if (a1 == a2 && a2 == a3 && a3 == a4 && a4 == a5) {
            return true;
        }
        return false;
    }
}



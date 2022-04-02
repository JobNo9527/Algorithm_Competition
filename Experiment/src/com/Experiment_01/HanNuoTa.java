package com.Experiment_01;

/**
 * @author 将晖
 */


public class HanNuoTa {
    //成员变量，定长A中有多少个盘子
    static int nDisks = 5;

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        doTower(nDisks, 'A', 'B', 'C');
    }

    public static void doTower(int topN, char from, char inter, char to) {
        if (topN == 1)
            System.out.println("Disk 1 from " + from + " to " + to);
        else {
            doTower(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTower(topN - 1, inter, from, to);
        }
    }
}

package com.Experiment_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 将晖
 */


public class HuiWen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean b = isPalindrome(s);
        System.out.println(b);
    }

    public static boolean isPalindrome(String pValue) {
        // 堆栈一
        List<Character> stack = new ArrayList<Character>();
        // 堆栈二
        List<Character> stack2 = new ArrayList<Character>();
        // 字符串长度的一半
        int haflen = pValue.length() / 2;

        for (int i = 0; i < haflen; i++) {
            // 字符进栈
            stack.add(pValue.charAt(i));
            // 倒序进栈
            stack2.add(pValue.charAt(pValue.length() - i - 1));
        }
        // 标识符
        boolean bFlag = true;
        // 出栈并比较
        for (int i = haflen - 1; i >= 0; i--) {
            if (stack.remove(i) != stack2.remove(i)) {
                bFlag = false;
                break;
            }
        }
        // 返回比对结果
        return bFlag;
    }
}

package com.isea.dw.dp;

/**
 * 汉诺塔问题：
 *  N层汉诺塔，from ， to ，借助help
 *  使用递归函数，主要分三步：
 *  ①：将1~n-1从from移动到help
 *  ②：将n从from移动到to
 *  ③：将help的n-1移动到to
 */
public class Hannoi {

    public static void main(String[] args) {
        int n = 3;
        process(n,"左","右","中");
    }

    private static void process(int n, String from, String to, String help) {
        if (n == 1){
            System.out.println("Move 1 from " + from + " to " + to);
        }else {
            process(n -1,from,help,to);
            System.out.println("Move " + n + " from " + from + " to " + to);
            process(n - 1,help,to,from);
        }
    }

}

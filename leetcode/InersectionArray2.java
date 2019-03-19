package com.isea.dw.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * LeetCode-350
 * 合并两个数组，对于重复元素的也保留
 */
public class InersectionArray2 {

    public static int[] merger(int[] num1,int[] num2){
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int i = 0; i < num1.length; i++) {
            hashSet.add(num1[i]);
        }

        ArrayList<Integer> help = new ArrayList<Integer>();
        for (int i = 0; i < num2.length; i++) {
            if (hashSet.contains(num2[i])){
                help.add(num2[i]);
            }
        }
        int[] res = new int[help.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = help.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] merger = merger(num1, num2);
        for (int i = 0; i < merger.length; i++) {
            System.out.print( " " + merger[i]);
        }
    }
}

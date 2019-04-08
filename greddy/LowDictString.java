package com.isea.dw.greddy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *给定一个字符串数组，要求将所有的字符串进行拼接，找打拼接之后字典序最小的字符串。
 *
 * 贪心策略1：将字符串排序，之后拼接，ba，b，排序之后是b，ba，那么会形成bba > bab了，
 * 		     该贪心策略不对
 * 贪心策略2：str1+str2 如果小于 str2+str1，那么将str1放在前面；否则str2放在前面
 */
public class LowDictString {
    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) { // a + b > b + a => 1 ; a + b < b + a => -1
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowDictString(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs,new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String[] strs = {"sea","long","ab","cd"};
        System.out.println(lowDictString(strs)); // abcdlongsea
    }
}

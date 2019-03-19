package com.isea.dw.leetcode;

/**
 * LeetCode-387
 * 找到一个字符串中，第一个没有重复的字符的索引，没有返回-1
 */
public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(find("abcaccc"));
    }

    public static int find(String str){
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return  -1;
    }
}

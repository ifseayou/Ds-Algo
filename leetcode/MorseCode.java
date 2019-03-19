package com.isea.dw.leetcode;

import java.util.HashSet;

/**
 * LeetCode-804，
 * 输入一些字符串，然后以单词为单位输出莫斯码的个数。
 */
public class MorseCode {
    public static void main(String[] args) {
        System.out.println(morseCode("gin zen gig msg"));
    }

    public static int morseCode(String str){
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> hashSet = new HashSet<String>();
        String[] words = str.split(" ");
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            hashSet.add(res.toString());
        }
        return hashSet.size();
    }
}

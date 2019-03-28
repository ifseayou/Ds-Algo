package com.isea.dw.string;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceVoid {

    public static String replace(String str) {
        StringBuilder res = new StringBuilder();
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(replace("we are family..."));
    }
}

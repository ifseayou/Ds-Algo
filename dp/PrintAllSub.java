package com.isea.dw.dp;

/**
 * 打印所有的一个字符串的所有子序列
 */
public class PrintAllSub {
    // 这里的res是上一次返回的子序列
    public static void printAllSub(char[] str,int i, String res){
        if (i == str.length){
            System.out.println(res);
            return;
        }
        // 不要当前的字符
        printAllSub(str, i +1,res);

        // 要当前的字符
        printAllSub(str,i +1 , res + String.valueOf(str[i]));
    }

    public static void main(String[] args) {
        printAllSub("abc".toCharArray(),0,"");
    }
}

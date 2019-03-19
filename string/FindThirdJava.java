package com.isea.dw.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 找到字符串中出现次数第三的字符
 */
public class FindThirdJava {
    public static void main(String[] args) {
        findThird("aaaaabbbbcccdddmm");
    }
    public static char findThird(String str){
        HashMap<Character, Integer> charNums = new HashMap<Character, Integer>();
        HashMap< Integer,Character> numsChar = new HashMap<Integer, Character>();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (charNums.containsKey(chars[i])){
                charNums.put(chars[i],charNums.get(chars[i])+1);
            }else{
                charNums.put(chars[i],1);
            }
        }
        System.out.println(charNums);

        for (Character character : charNums.keySet()) {
            numsChar.put(charNums.get(character),character);
        }

        System.out.println(numsChar);

        Object[] orders = charNums.values().toArray();
        Arrays.sort(orders, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                return (Integer) o2 - (Integer) o1;
            }
        });
        return numsChar.get(orders[2]);
    }
}

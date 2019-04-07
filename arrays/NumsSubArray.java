package com.isea.dw.arrays;

import java.util.LinkedList;

/**
 * 子数组的问题：最大值-最小值 <= num的子数组的个数
 *
 * 子数组必须是连续的。
 *
 * 要求时间复杂度：假设数组的长度是N，时间复杂度是O(N)
 *
 * 最优解：
 * ①：如果一个子数组已经达标了，比它小的子数组都应该达标
 * ②：如果一个子数组没有达标，那么比它大的子数组都不会达标
 *
 * 维护一个min的队列，维护一个max的队列，刚开始的时候，L停留在0的位置，R停留在第一个不达标位置的前一个位置
 * 此时可以得到以L开头所有达标的子数组，此后L每次右移一位，min，和Max队列更新，右扩；直到所有值开头的子数组都找到；
 *
 * min和max队列，进出都只是一次，时间复杂度是O(N)
 */
public class NumsSubArray {

    // 暴力的方法求解，此时由于子数组的个数是O(N ^ 2)的，暴力方法找到了所有的子数组，O(N ^ 2)的，isValid方法遍历了一遍，所以时间复杂读书度是O(N ^ 3)的
    public static int getNumsByViolence(int[] arr,int num){
        if (arr == null){
            throw new IllegalArgumentException("Array is null...");
        }
        int res = 0;
        for(int start = 0; start < arr.length ; start ++){
            for(int end = start; end < arr.length ; end ++){
                if (isValidByViolence(arr,start,end,num)){
                    res ++;
                }
            }
        }
        return res;
    }

    public static boolean isValidByViolence(int[] arr, int start, int end , int num){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start;i <= end; start ++){
           Math.max(max,arr[i]);
           Math.min(min,arr[i]);
        }
        return max - min <= num;
    }

    //下面介绍O(N)
    public static int getNums(int[] arr, int num){
        if (arr == null || arr.length == 1){
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();

        int L = 0;
        int R = 0;
        int res = 0;
        while(L < arr.length){
            // 当L确定的时候，R往右边扩充，扩到不能在扩的时候，停止
            while(R < arr.length){
                // 维护最小值双端队列
                while(!qmin.isEmpty() && qmin.peekLast() >= arr[R]){
                    qmin.pollFirst();
                }
                qmin.addLast(arr[R]);

                while(!qmax.isEmpty() && qmax.peekLast() <= arr[R]){
                    qmax.pollFirst();
                }
                qmax.addLast(arr[R]);

                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                R ++;
            }

            // 最小值的队列，下标是否过期
            if (qmin.peekFirst() == L){
                qmin.pollFirst();
            }

            // 最大值的队列，下标是否过期
            if (qmax.peekFirst() == L){
                qmax.pollFirst();
            }

            res += R - L;
            L ++;
        }

        return res;
    }
}

package com.isea.dw.leetcode;

import java.util.HashMap;

/**
 * leetcode001
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 实现
 */
public class LeetCode001 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        for (int re : res) {
            System.out.print(re  + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexNum.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i] ;
            if (indexNum.containsKey(complete) && indexNum.get(complete) != i){
                return new int[] {i,indexNum.get(complete)};
            }
        }
        throw new IllegalArgumentException("No such solution...");
    }
}

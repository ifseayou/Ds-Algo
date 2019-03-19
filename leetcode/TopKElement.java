package com.isea.dw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode-347
 * 求解一个数组中出现1-k的元素
 *
 */
public class TopKElement {
    private static class NumFreq implements Comparable<NumFreq> {
        int ele, count;

        public NumFreq(int ele, int count) {
            this.ele = ele;
            this.count = count;
        }

        @Override
        public int compareTo(NumFreq o) {
            return o.count - this.count;
        }
    }


    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (k < 0) {
            return null;
        }

        HashMap<Integer, Integer> eleCounts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (eleCounts.containsKey(nums[i])) {
                eleCounts.put(nums[i], eleCounts.get(nums[i]) + 1);
            } else {
                eleCounts.put(nums[i], 1);
            }
        }

        PriorityQueue<NumFreq> priorityQueue = new PriorityQueue<>();

        for (Integer integer : eleCounts.keySet()) {
            priorityQueue.add(new NumFreq(integer, eleCounts.get(integer)));
        }

        if (k > priorityQueue.size()) {
            throw new IllegalArgumentException("Illegal args...");
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll().ele);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 5, 5, 5, 5};
        System.out.println(topKFrequent(nums, 2));
    }


}

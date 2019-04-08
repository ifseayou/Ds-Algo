package com.isea.dw.greddy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * cost  [........] 该项目要花费多少钱，
 * profit[........] 该项目会收益多少钱
 * w 为启动资金，每次只能做一个项目，如果想要做项目的话，当前手里的启动资金要大于项目的花费
 * k 最多做k个项目
 * 最终获取的最大收益（也就是最终的启动资金）
 *
 * 解决：
 * 所有的项目，按照cost的维度，生成小根堆，然后只要cost小于w的，弹出，按照profit的维度放置到大根堆中
 * 小根堆里面是所有的项目，大根堆里面是解锁的项目，然后在开始弹出（做）大根堆里的项目，此时w增加，在去判断
 * 小根堆里还可以解锁哪些项目，一直做K个结束，或者是做到最后不能做了（大根堆空了）
 *
 */
public class IPO {
    public static class Program {
        private int c;
        private int p;
        public Program(int c , int p){
            this.c = c;
            this.p = p;
        }
    }
    public static class MinCostComparator implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements  Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }
    }

    public static int maxProfit(int w,int k,int[] costs,int[] profits){
        // 将数组封装为项目
        Program[] programs = new Program[costs.length];
        for (int i = 0; i < costs.length; i++) {
            programs[i] = new Program(costs[i],profits[i]);
        }

        PriorityQueue<Program> minCostHeap = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Program> maxProfitHeap = new PriorityQueue<>(new MaxProfitComparator());

        // 将所有的项目都放置到小根堆中
        for (Program program : programs) {
            minCostHeap.add(program);
        }

        // 开始做项目，
        for (int i = 0; i < k; i++) {
            // 解锁项目
            while(!minCostHeap.isEmpty() && minCostHeap.peek().c < w){
                maxProfitHeap.add(minCostHeap.poll());
            }
            // 如果大根堆没有了项目，说明无法解锁新的项目了
            if (maxProfitHeap.isEmpty()){
                return w;
            }
            w += maxProfitHeap.poll().p;
        }
        return w;
    }
    public static void main(String[] args) {
        int[] costs = {10,20,30};
        int[] profits = {3,4,5};
        System.out.println(maxProfit(17, 3, costs, profits));
    }
}

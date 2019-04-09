package com.isea.dw.greddy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个项目数组，一个项目中含有开始时间和结束时间，目前只有一个会议室，一个会议室只能容纳一个项目宣讲，返回该会议室最多的场次
 * <p>
 * 解决：按照项目结束的时间的先后（end小的在前面）对项目排序，对于传入的时间cur，如果大于当前项目的start时间，就可以做
 * 否则就开始做下一个项目
 */

public class BestArrange {
    public static class Program {
        private int start;
        private int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class EndComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int curTime) {
        if (programs == null || programs.length == 0) {
            return 0;
        }
        Arrays.sort(programs, new EndComparator());
        int res = 0;

        // 遍历所有的项目，然后对比当前项目的start和curTime之间的关系
        for (int i = 0; i < programs.length; i++) {
            if (curTime <= programs[i].start) {
                res++;
                curTime = programs[i].end;
            }
        }
        return res;
    }
}
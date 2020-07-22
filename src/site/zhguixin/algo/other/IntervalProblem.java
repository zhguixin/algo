package site.zhguixin.algo.other;

import java.util.Arrays;
import java.util.Comparator;

// 区间问题, 区间合并: https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/qu-jian-tiao-du-wen-ti-zhi-qu-jian-he-bing
// 区间交集: https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/qu-jian-jiao-ji-wen-ti
public class IntervalProblem {

    // 戳破气球问题
    // 输入[ [10,16], [2,8], [1,6] [7,12]  ]
    // 放箭不戳破气球, 就是找出有多少个不重叠的区间
    public int findMinArrowShots(int[][] intvs) {
        int len = intvs.length;

        // 突破点: 先对这些区间按照终点排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        int x_end = intvs[0][1];// 第一个区间的终点[10,16], 即16
        for (int[] intv : intvs) {
            int start = intv[0];// 区间的起点
            if (start >= x_end) {// 当前区间的起点大于等于上一个区间的终点就没有重叠, 可以放箭不会戳破气球
                count++;
                x_end = intv[1];
            }
        }

        return count;
    }


}

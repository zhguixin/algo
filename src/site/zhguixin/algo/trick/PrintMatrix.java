package site.zhguixin.algo.trick;

import java.util.ArrayList;
import java.util.List;

// 顺时针螺旋打印矩阵
// LeetCode 54
public class PrintMatrix {

    public void print(int[][] nums) {
        int up = 0;
        int down = nums.length - 1;
        int left = 0;
        int right = nums[0].length - 1;
        List<Integer> list = new ArrayList<>();

        // 每打印完一行, 直接排除该行
        while (true) {
            // 打印上边界
            for (int i = left; i <= right; i++) {
                list.add(nums[up][i]);// 向右
            }
            if (++up > down) break;

            // 打印右边界
            for (int i = up; i <= down; i++) {
                list.add(nums[i][right]);// 向下
            }
            if (--right < left) break;

            // 打印下边界
            for (int i = right; i >= left; i--) {
                list.add(nums[down][i]);// 向左
            }
            if (--down < up) break;

            // 打印左边界
            for (int i = down; i >= up; i--) {
                list.add(nums[left][i]);// 向上
            }
            if (++left > right) break;
        }
    }
}

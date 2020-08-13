package site.zhguixin.algo.dualpointer;

import java.util.Arrays;

// 给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序
public class MoveZero {

    // 利用快慢指针操作
    public void getArr(int[] nums) {
        int fast = 1, slow = 0;

        while (slow < fast) {
            if (fast >= nums.length) {
                break;
            }
            if (nums[fast] != 0 && nums[slow] == 0) {
                swap(nums, slow, fast);
                fast++;
                slow++;
            } else {
                fast++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

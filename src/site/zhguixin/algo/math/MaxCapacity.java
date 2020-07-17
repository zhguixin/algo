package site.zhguixin.algo.math;

public class MaxCapacity {

    // a[i..j]组成的容器最大容量
    public int max(int[] nums) {
        int i = 0, j = nums.length - 1;
        int result = 0;
        while (i < j) {
            // 容器盛水的取决于最短的边
            int minHeight = Math.min(nums[i], nums[j]);
            result = Math.max(result, minHeight * (j - i));
            // 短的那个边向中间靠拢
            if (nums[i] > nums[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}

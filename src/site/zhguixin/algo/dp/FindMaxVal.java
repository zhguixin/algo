package site.zhguixin.algo.dp;

import java.util.Arrays;

public class FindMaxVal {

    // 给定一个数组, 求该数组的连续子数组最大和
    public int findMaxSum(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums[0]);

        for(int i = 1; i < nums.length; i++) {
            System.out.println((dp[i-1] + nums[i]));
            System.out.println(nums[i]);
            // 状态转移方程
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            System.out.println(dp[i]);
        }

        int max = dp[0];
        for (int i = 0; i < nums.length - 1;i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}

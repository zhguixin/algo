package site.zhguixin.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 最长递增子序列
public class LIS {

    // 返回最长递增子序列的长度
    public int getLIS(int[] nums) {
        // dp[i]表示以nums[i]结尾的元素最长递增序列长度
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 0;i <nums.length;i++) {
            for (int j=0;j<i;j++) {
                if (nums[i] > nums[j]) {// 找到前面子序列中比num[i]小的, 拼接看看哪个长度最大
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i <dp.length;i++) {
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }

    // 求最长递增子串的Top k, 子串一定是连续的!!
    public List<List<Integer>> getLongestSub(int[] nums, int K) {
        List<List<Integer>> res = new ArrayList<>();
        // dp[i]表示以nums[i]为结尾的最长子串
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i <nums.length;i++) {// 子串是连续的, 只需要一个for循环就可以, 不需要回头
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
        }

        // 遍历完一遍后, dp数组存储了以i下标为结尾的最长递增子串的长度
        // 可以求出top k长的最长递增子串
        for (int i = 0; i < K; i++) {
            int maxLenIndex = 0;

            //先遍历一遍dp数组获取最大长度所在的索引位置
            for (int j=0;j<dp.length;j++) {
                if (dp[j] > dp[maxLenIndex]) {
                    maxLenIndex = j;
                }
            }

            List<Integer> cur = new ArrayList<>();
            // 找到了最大长度递增子串的结尾index, 即为maxLenIndex
            // 现在结尾index知道, 长度也知道dp[maxLenIndex], 可以输出这个子串了
            for (int l = maxLenIndex - dp[maxLenIndex] + 1; l <= maxLenIndex;l++) {
                cur.add(nums[l]);
                dp[l] = 1;// 这个位置置为1(即dp数组的默认值), 因为最长的子串已经取出了
            }
            res.add(cur);
        }

        return res;
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] nums = {2,1,4,5,8,3,7,10,2,5};
        List<List<Integer>> res = lis.getLongestSub(nums, 2);
        System.out.println("res=" + res);
    }
}

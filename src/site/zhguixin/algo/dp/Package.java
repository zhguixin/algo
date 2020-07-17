package site.zhguixin.algo.dp;

// 0-1背包问题
public class Package {

    /**
     * N = 3, W = 4
     * val = [4,2,3]
     * wt = [2,1,3]
     */


    // 背包重量为W, 物品个数为N
    public int putPackage(int[] wt, int W, int[] val, int N) {
        int[][] dp = new int[N+1][W+1];
        for (int i = 1; i <= N; i++) {// 要装入的第i个物品
            for (int j = 1; j <= W; j++) {// 第i个物品的重量为j
                if (j - wt[i-1] < 0) {// 当前背包已经装不下了
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-wt[i-1]] + val[i-1],
                            dp[i-1][j]);
                }
            }
        }
        // N个物品全部装入并且得到背包重量
        return dp[N][W];
    }

    // 分割等和子集，一个正整数数组(和为sum)，把这个数组分割成两个等和(sum/2)的数组
    // 转换为背包问题, 从数组中取出数据使得他们的和为sum/2
    public boolean splitSameSumArray(int[] nums) {

        return false;
    }
}

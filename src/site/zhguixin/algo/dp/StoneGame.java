package site.zhguixin.algo.dp;

public class StoneGame {

    public int stoneGame(int[] nums) {
        int len = nums.length;
        Pair[][] dp = new Pair[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                // 两层for循环初始化dp数组
                dp[i][i] = new Pair(0,0);
            }
        }
        for(int i = 0; i < len; i++) {
            // 一个for循环初始化dp数组可知的初始值
            dp[i][i].fir = nums[i];
            dp[i][i].sec = 0;
        }

        for(int k = 2; k <= len;k++) {
            for(int i = 0; i <= len - k;i++) {
                int j = k + i - 1;
                // 先手选择最左边，他面对的石头堆[i+1,j]就变成后手了
                int left = nums[i] + dp[i+1][j].sec;
                int right = nums[j] + dp[i][j-1].sec;
                // 先手肯定选取最大的石头数目
                dp[i][j].fir = Math.max(left, right);
                // 后手在先手选择之后挑选
                if(left > right) {// 说明先手选择了left，后手面对石头堆[i+1,j]变成先手
                    dp[i][j].sec = dp[i+1][j].fir;
                } else {
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }

        return dp[0][len-1].fir - dp[0][len-1].sec;
    }

    public void test(int[][] nums) {
        int len = nums.length;
        // dp[i][j] 的转移由dp[i+1][j]、dp[i][j-1]来确定
        // for循环遍历如下：
        for (int k=2; k < len;k++) {
            for (int i = 0; i <= len-k;i++) {
                int j = k + i - 1;
            }
        }
    }
}

package site.zhguixin.algo.dp;

// 在一个n*n的矩阵中查找最短路径
public class FindMinDst {

    // 状态转移方程:dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1])
    public int find(int[][] matrix, int n) {
        int[][] dp = new int[n][n];

        // 初始化dp数组的第一行数据
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += matrix[0][j];
            dp[0][j] = sum;
        }
        sum = 0;
        // 初始化dp数组的第一列数据
        for (int i = 0; i < n; i++) {
            sum += matrix[i][0];
            dp[i][0] = sum;
        }

        // 站在matrix[1][1]的位置上开始行走, 避免i-1或者j-1越界
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][n - 1];
    }
}

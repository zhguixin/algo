package site.zhguixin.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个三角形, 求出最短路径和
public class TriangleMinSum {

    public int minSum(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        // dp数组依次保存从上向下计算出来的数字
        int[][] dp = new int[m][n];

        System.out.println(dp.length);

        //根据list填充dp数组, dp数组现在只在对角线下方有值
        for(int i = 0; i<dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j);
            }
        }

        // 计算第一列的值, 和对角线上的值
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] += dp[i-1][0];// 第一列的值只与上一行的值相加
            dp[i][i] += dp[i-1][i-1];// 对角线的上的值, 只取上一个对角线上的值
        }

        // 从第二行开始, 计算第一列与对角线之间的值
        for(int i = 2; i<dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] += Math.min(dp[i-1][j], dp[i-1][j-1]);
            }
        }

        // 最后一行中是计算得到的和, 取最大值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[m-1][i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));

        TriangleMinSum triangleMinSum = new TriangleMinSum();
        triangleMinSum.minSum(triangle);
    }
}

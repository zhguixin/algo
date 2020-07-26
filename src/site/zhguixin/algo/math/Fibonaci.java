package site.zhguixin.algo.math;

import site.zhguixin.algo.dp.LCS;

public class Fibonaci {

    // 求前n项的斐波那契数列之和
    public int getFibonaci(int n) {
        // dp[i]第i项的和
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i <= n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int getFibonaci2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int pre =0, cur = 1;
        for (int i = 2;i<=n;i++) {
            int sum = pre + cur;
            pre = cur;
            // cur存储的就是之前项的和
            cur = sum;
        }

        return cur;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Fibonaci fibonaci = new Fibonaci();
        int res = fibonaci.getFibonaci2(8);
        System.out.print("res=" + res);
    }
}

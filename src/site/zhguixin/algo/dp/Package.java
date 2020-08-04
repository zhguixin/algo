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

    public int putPackageBase(int[] nums, int W) {
        int len = nums.length;
        int[][] dp = new int[len+1][W+1];
        for (int i = 1; i <= len; i++) {// 要装入的第i个物品
            for (int j = 1; j <= W; j++) {// 第i个物品的重量为j
                if (j - nums[i-1] < 0) {// 当前背包已经装不下了
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-nums[i-1]],
                            dp[i-1][j]);
                }
            }
        }
        // N个物品全部装入并且得到背包重量
        return dp[len][W];
    }


//    weight:物品重量，n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        // dp[i][j], 表示此时放置第i个物品时，背包里的重量为j，结果背包是否已满
        boolean[][] states = new boolean[n][w+1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) {//把第i个物品放入背包
                if (states[i-1][j]==true) states[i][j+weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n-1][i] == true) return i;
        }
        return 0;
    }


    public int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值
    // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
    // w背包重量；items表示每个物品的重量；n表示物品个数
    // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i+1, cw, items, n, w);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            f(i+1,cw + items[i], items, n, w);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Package aPackage = new Package();
        int[] nums = {2,2,4,6,3};int W = 9;
        int res = aPackage.knapsack(nums, nums.length, W);
        int res2 = aPackage.putPackageBase(nums, W);
        System.out.print("res=" + res + ";res=" + res2);
    }
}

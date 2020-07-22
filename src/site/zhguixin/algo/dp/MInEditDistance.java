package site.zhguixin.algo.dp;

public class MInEditDistance {

    // 求两个字符串的最小编辑距离
    public int getMinEditDistance(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int len1 = ch1.length; int len2 = ch2.length;
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i < len1;i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (ch1[i-1] == ch2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = min(
                            dp[i][j-1] + 1,
                            dp[i-1][j] + 1,
                            dp[i-1][j-1] + 1
                    );
                }
            }
        }

        return dp[len1][len2];
    }

    private int min(int a1, int a2, int a3) {
        return Math.min(a1, Math.min(a2, a3));
    }

    public static void main(String[] args) {
        MInEditDistance mInEditDistance = new MInEditDistance();
//        int res = mInEditDistance.getMinEditDistance("horse", "ros");
//        System.out.println("res=" + res);

        int res = mInEditDistance.getLength("babad");
        System.out.println("res=" + res);
    }

    // 求字符串str的最长回文子序列, dp[i][j]表示str[i..j]的回文序列长度
    public int getLength(String str) {
        char[] ch = str.toCharArray();
        int len = ch.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len;i++) {
            dp[i][i] = 1;
        }

        // 两种不同的遍历方式: 从右下角开始遍历
//        for (int i = len -1; i>=0;i--) {
//            for (int j = i +1;j <len;j++) {
//                if (ch[i] == ch[j]) {
//                    dp[i][j] = dp[i+1][j-1] + 2;
//                } else {
//                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
//                }
//            }
//        }

        // 从左上角开始遍历
        // 要保证j>=i, 头部不能超过尾部
        for (int i = 0; i < len;i++) {
            // j从i+1的位置开始, （i==j的位置已经被填充过了)避免越界
            for (int j = i+1; j<len;j++) {
                if (ch[i] == ch[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}

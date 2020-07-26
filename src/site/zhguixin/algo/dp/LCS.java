package site.zhguixin.algo.dp;

public class LCS {

    // 获取两个字符串的最长公共子串
    public int getLCS(String str1, String str2)  {
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLen = 0, maxIndex = 0;
        int[][] dp = new int[len1+1][len2+1];

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (int i = 1; i <=len1;i++) {
            for (int j=1;j<=len2;j++) {
                if (ch1[i-1] == ch2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
//                } else { // 最长公共子序列, dp[m][n]
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }

                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                    maxIndex = i;// 记录i字符串中最长子串位置的最后一位索引
                }
            }
        }
        System.out.println(str1.substring(maxIndex-maxLen+1, maxIndex));
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LCS lcs = new LCS();
        int res = lcs.getLCS("acbcbcef", "abcbced");
        System.out.print("res=" + res);
    }
}

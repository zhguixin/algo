package site.zhguixin.algo.dp;

import java.util.ArrayDeque;
import java.util.Arrays;

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

    // 最长公共子序列
    public int getLCS2(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int len1 = ch1.length, len2 = ch2.length;

        int[][] dp = new int[len1+1][len2+1];
        int[][] flag = new int[len1+1][len2+1];
//        Arrays.fill(dp, 0);
//        Arrays.fill(flag, 0);

        for (int i = 1; i <= len1;i++) {
            for (int j = 1; j <=len2;j++) {
                if (ch1[i-1] == ch2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    flag[i][j] = 1;
                } else if (dp[i-1][j] > dp[i][j-1]) {// ch1[i-1],ch2[j]结尾的子序列长度最大
                    dp[i][j] = dp[i-1][j];
                    flag[i][j] = 2;
                } else {
                    dp[i][j] = dp[i][j-1];
                    flag[i][j] = 3;
                }
            }
        }

        int maxLen = dp[len1][len2];
        StringBuilder builder = new StringBuilder();

        // 通过flag记录的数值,从后向前遍历flag数组,逆序输出公共子序列
        for (int i=len1, j=len2;j >0 && i>0;) {
            if (flag[i][j] == 1) {
                builder.append(ch1[i]);
                i--;j--;
            } else if (flag[i][j] == 2) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(builder.reverse());
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LCS lcs = new LCS();
        int res = lcs.getLCS("acbcbcef", "abcbced");
        String s1="ABCPDSFJGODIHJOFDIUSHGD";
        String s2="OSDIHGKODGHBLKSJBHKAGHI";
        int res2 = lcs.getLCS2(s1, s2);
        System.out.print("res=" + res + ";res2=" + res2);
    }
}

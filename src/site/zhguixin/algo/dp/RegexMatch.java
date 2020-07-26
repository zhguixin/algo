package site.zhguixin.algo.dp;

public class RegexMatch {

    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // 初始化dp数组
        dp[text.length()][pattern.length()] = true;

        // 从字符串尾部开始比较
        // 从后向前填充dp数组
        for (int tIndext = text.length(); tIndext >= 0; tIndext--){
            for (int pIndext = pattern.length() - 1; pIndext >= 0; pIndext--){
                boolean curMatch = (tIndext < text.length() &&
                        (pattern.charAt(pIndext) == text.charAt(tIndext) ||
                                pattern.charAt(pIndext) == '.'));

                if (pIndext + 1 < pattern.length() && pattern.charAt(pIndext+1) == '*'){
                    dp[tIndext][pIndext] = dp[tIndext][pIndext+2] || curMatch && dp[tIndext+1][pIndext];
                } else {
                    dp[tIndext][pIndext] = curMatch && dp[tIndext+1][pIndext+1];
                }
            }
        }
        return dp[0][0];
    }
}

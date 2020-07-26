package site.zhguixin.algo.trace;

// 正则表达式匹配(与LeetCode上的正则匹配不一样)
public class RegexMatch {
    private char[] pattern;
    private boolean isMatched;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        char[] p = {'a','*','a','b'};
        char[] text = {'a','a','a','a','a','b'};
        RegexMatch pattern = new RegexMatch(p);
        System.out.print(pattern.match(text));
    }

    public RegexMatch(char[] pattern) {
        this.pattern = pattern;
    }

    public boolean match(char[] text) {
        rematch(text, 0 ,0);
        return isMatched;
    }

    private void rematch(char[] text, int tIndex, int pIndex) {
        // 递归出口
        if (pIndex == pattern.length) {
            if (tIndex == text.length) isMatched = true;
            return;
        }

        if (pattern[pIndex] == '*') {// 匹配当前0个或多个文本元素
            for (int k =0;k<= text.length -tIndex;k++) {
                rematch(text, tIndex+k, pIndex+1);
            }
        } else if (tIndex < text.length && pattern[pIndex] == text[tIndex]) {
            rematch(text, tIndex + 1, pIndex + 1);
        }
    }

    // 实现 . 和 * 的正则匹配，.匹配任意单个元素，*匹配前面零个或多个元素
    public boolean regexMatch(char[] text) {

        return false;
    }

    private void rematch2(char[] text, int tIndex, int pIndex) {
        // 递归出口

        if (pattern[pIndex] == '*') {// 匹配当前0个或多个文本元素
            for (int k =0;k<= text.length -tIndex;k++) {
                rematch(text, tIndex+k, pIndex+1);
            }
        } else if (tIndex < text.length && pattern[pIndex] == text[tIndex]) {
            rematch(text, tIndex + 1, pIndex + 1);
        }
    }
}

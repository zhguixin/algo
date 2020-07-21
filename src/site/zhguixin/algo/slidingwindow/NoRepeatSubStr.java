package site.zhguixin.algo.slidingwindow;

// 在一个字符串中找到最长不重复子串的长度
public class NoRepeatSubStr {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        NoRepeatSubStr noRepeatSubStr = new NoRepeatSubStr();
        String str = "abcabcbb";
//        String str = "bbbbbbb";
        noRepeatSubStr.find(str.toCharArray());
    }

    public int find(char[] strs) {
        // 用char字符做索引, 记录滑动窗口中的字符是否出现过
        int[] strCount = new int[256];

        char[] subStr = new char[strs.length];

        int left = 0, right = 0;
        int result = 0;

        while (right < strs.length) {
            char c = strs[right];
            strCount[c]++;
            right++;

            while (strCount[c] > 1) {
//                char tempLeft = strs[left];
                strCount[c]--;
                left++;
            }
            result = Math.max(right - left, result);

            if (right - left >= result) {
                for (int i = left; i < right; i++) {
                    subStr[i-left] = strs[i];
                }
            }
        }

        for (int i = 0; i < subStr.length; i++) {
            System.out.println("res=" + subStr[i]);
        }
        System.out.println("result=" + result);
        return result;
    }
}

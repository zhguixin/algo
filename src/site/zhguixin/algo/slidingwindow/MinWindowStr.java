package site.zhguixin.algo.slidingwindow;

// 最小覆盖子串: LeetCode 76
// https://leetcode-cn.com/problems/minimum-window-substring/
public class MinWindowStr {

    public void minStr(char[] source, char[] target) {
        char[] need = new char[256];
        char[] window = new char[256];

        for (int i = 0; i < target.length;i++) {
            window[target[i]]++;
        }

        int left = 0, right = 0;
        while (right < source.length) {
            need[source[right]]++;
            right++;

            while (isValid()) {
                need[source[left]]--;
                left++;
            }

            for (int i = left; i < right; i++) {
                System.out.println(source[i]);
            }
        }

    }

    private boolean isValid() {

        return false;
    }
}

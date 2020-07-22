package site.zhguixin.algo.trace;

import java.util.ArrayList;
import java.util.List;

// 手机数字匹配
public class NumToLetter {
    String[] mapping = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        NumToLetter letter = new NumToLetter();
        letter.combine("234");
    }

    public void combine(String digits) {
        traceBack(new StringBuilder(), 0, digits);
    }

    // index为输入的数字字符串中的第几个数字
    private void traceBack(StringBuilder str, int index, String digits) {
        if (index == digits.length()) {
            System.out.println("str=" + str.toString());
            res.add(str.toString());
            return;
        }

        char[] charArray = digits.toCharArray();
        // 目前回溯到第几个数字
        int num = Character.getNumericValue(charArray[index]);
        // 取出数字对应的字符串
        String item = mapping[num];
        for (char ch : item.toCharArray()) {
            str.append(ch);
            traceBack(str, index + 1, digits);
            str.deleteCharAt(str.length() - 1);
        }
    }
}

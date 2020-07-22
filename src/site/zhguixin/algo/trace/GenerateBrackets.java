package site.zhguixin.algo.trace;

import java.util.ArrayList;
import java.util.List;

// 给定整数n, 数出所有合法的括号:()
public class GenerateBrackets {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        GenerateBrackets generateBrackets = new GenerateBrackets();
        List<String> resList = new ArrayList<>();
        generateBrackets.generate(2, resList);

        for (String str : resList) {
            System.out.println(str);
        }
    }

    public void generate(int n, List<String> list) {
        if (n == 0) {
            return;
        }
        traceBack(n , n, new StringBuilder(), list);
    }

    private void traceBack(int left, int right, StringBuilder bracket, List<String> res) {
//        System.out.println("》》》left=" + left + ";right=" + right);
//        System.out.println("bracket=" + bracket + "《《《");

        // 剩下的左括号多, 直接返回
        if (left > right) {
            return;
        }
        // 左右括号其中一个已经使用完, 直接返回
        if (left < 0 || right < 0) {
            return;
        }

        // 左右括号都使用完, 是一个合法的括号
        if (left == 0 && right == 0) {
            res.add(bracket.toString());
            return;
        }

        // 尝试回溯
        // 做出选择
        bracket.append('(');
        traceBack(left - 1, right, bracket, res);
        // 撤销选择
        bracket.deleteCharAt(bracket.length() - 1);

        // 做出选择
        bracket.append(')');
        traceBack(left, right - 1, bracket, res);
        // 撤销选择
        bracket.deleteCharAt(bracket.length() - 1);
    }
}

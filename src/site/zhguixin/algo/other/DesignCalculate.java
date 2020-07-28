package site.zhguixin.algo.other;

import java.util.ArrayDeque;
import java.util.Deque;

// 根据输入的字符串求数值: 1 - (2*3)
public class DesignCalculate {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        DesignCalculate calculate = new DesignCalculate();
        calculate.calc("1-12+3*1/1");
    }

    private Deque<Integer> stack = new ArrayDeque<>();

    public void calc(String str) {
        calculate(str.toCharArray());
    }

    // 对于字符串:1-12+3, 入栈[+1   -12   +3], 然后从栈里取出所有数据相加即可
    // 只计算+ - * / 不包含括号
    private void calculate(char[] str) {
        int num = 0;
        char sign = '+';// 默认首个字符为+
        for (int i =0; i < str.length;i++) {
            char ch = str[i];
            if (Character.isDigit(ch)) {
                num = 10 * num + (ch - '0');
            } else if (!Character.isDigit(ch) && ch != ' ' || i == str.length - 1) {// 行进到最后位置时入栈之前的数字
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':// 取出栈顶元素相乘后再放入栈
                        int result1 = stack.pop() * num;
                        stack.push(result1);
                        break;
                    case '/':// 取出栈顶元素相除后再放入栈
                        int result2 = stack.pop() / num;
                        stack.push(result2);
                        break;
                }
                // 数字清零
                num = 0;
                // 符号更新为当前符号
                sign = ch;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        System.out.println("result=" + res);
    }

    // 括号问题处理
    // https://leetcode-cn.com/problems/basic-calculator/solution/ji-ben-ji-suan-qi-by-leetcode/
}

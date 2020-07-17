package site.zhguixin.algo.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

// 最小栈,getMin获得栈中元素的最小值
// 通过构造辅助栈, 保存入栈的最小元素可以实现该算法,空间复杂度O(N)
public class MinStack {

    private Deque<Integer> stack;
    // 辅助栈, 保存入栈时的最小值
    private Deque<Integer> assitStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        assitStack = new ArrayDeque<>();
    }

    public void push(Integer num) {
        stack.push(num);
        // 当辅助栈栈顶大于等于入栈元素时,也要把该元素压入辅助栈
        if (assitStack.isEmpty() || assitStack.peek() >= num) {
            assitStack.push(num);
        }
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        Integer num = stack.pop();
        // 出栈元素是辅助栈的栈顶元素时, 辅助栈栈顶元素也要出栈
        if (Objects.equals(num, assitStack.peek())) {
            assitStack.pop();
        }
        return num;
    }

    public Integer getMin() {
        return assitStack.peek();
    }
}

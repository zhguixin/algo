package site.zhguixin.algo.collection;

import java.util.ArrayDeque;
import java.util.Deque;

// 两个栈实现一个队列
public class StackToQueue {

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> stackFlag = new ArrayDeque<>();

    // 只向数据栈存放数据
    public void putQueue(Integer val) {
        stack.push(val);
    }

    // 取出数据栈的栈底元素
    public Integer getQueue() {
        if (stack.isEmpty()) {
            return null;
        }
        while (stack.size() > 1) {
            stackFlag.push(stack.pop());
        }
        Integer res = stack.pop();

        // 所有元素再全部放回数据栈
        while (!stackFlag.isEmpty()) {
            stack.push(stackFlag.pop());
        }
        return res;
    }
}

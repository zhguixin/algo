package site.zhguixin.algo.collection;

import java.util.Deque;
import java.util.LinkedList;

// 两个队列实现一个栈
public class QueueToStack {
    private Deque<Integer> queue = new LinkedList<>();
    private Deque<Integer> queueFlag = new LinkedList<>();
    // 保存栈顶元素
    private Integer stackTop;

    // 入栈只存放数据队列, 并更新栈顶元素
    public void push(Integer val) {
        queue.offer(val);
        stackTop = val;
    }

    // 出栈先把数据队列(除最后一个元素其余)的元素全部出队到辅助队列
    public Integer pop() {
       if (queue.isEmpty()) {
           return null;
       }
       while (queue.size() > 1) {
           queueFlag.offer(queue.poll());
       }
       Integer res = queue.poll();
       if (!queueFlag.isEmpty()) {
           stackTop = queueFlag.peek();
       }

       while (!queueFlag.isEmpty()) {
           queue.offer(queueFlag.poll());
       }
       return res;
    }

    public Integer peek() {
        return stackTop;
    }
}

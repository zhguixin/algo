package site.zhguixin.algo.collection;

import java.util.ArrayDeque;
import java.util.Deque;

// 单调栈, 只有一个出口, 保证单调栈的有序性是在push操作里:
// 为保证栈顶元素始终最大,因此要比即将入栈的元素大的栈顶元素出栈
public class SortStack {


    /*
        求解下一个最大数的数组
        给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
        解释：第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；第二个 2 后面比 2 大的数是 4; 4 后面没有比 4 大的数，填 -1；3 后面没有比 3 大的数，填 -1。
     */
    public void nextGreaterElement(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i>=0; i--) { // 倒着往栈里放 ???存疑
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                System.out.println(stack.peek());
            } else {
                System.out.println(-1);
            }
            stack.push(nums[i]);
        }
    }

    /*
    单调栈性质：
    1. 单调栈里的元素具有单调性。
    2. 递增（减）栈中可以找到元素左右两侧比自身小（大）的第一个元素。

    我们主要使用第二条性质，该性质主要体现在栈调整过程中，下面以递增栈为例（假设所有元素都是唯一），当新元素入栈。
    + 对于出栈元素来说：找到右侧第一个比自身小的元素。
    + 对于新元素来说：等待所有破坏递增顺序的元素出栈后，找到左侧第一个比自身小的元素。
     */

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SortStack sortQueue = new SortStack();
        int[] nums = {2,1,2,4,3};
        sortQueue.nextGreaterElement(nums);
    }
}

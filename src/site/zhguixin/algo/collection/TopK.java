package site.zhguixin.algo.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {

    // 利用优先级队列来实现TopK问题
    // 给定一个数组, 找出其中前K大的数字
    // 基本思路: 维护一个大小为K的小顶堆，如此一来堆顶是最小的元素，后续进来的元素直接与堆顶元素比较：
    // （1）比堆顶元素小,直接丢弃
    // （2）比堆顶元素大,丢弃堆顶元素, 插入新进来的元素
    public void getTopK(int[] nums, int k) {
        // k只是初始大小, 会扩容的, 默认是小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        int len = nums.length;

        for (int i = 0; i < len;i++) {
            if (i < k) {
                pq.add(nums[i]);
            } else {
                int temp = pq.peek();
                if (nums[i] > temp) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

        // 大顶堆的实现
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        int[] nums = {9, 5, 2, 7, 3, 6, 8, 1};
        topK.getTopK(nums, 3);
    }
}

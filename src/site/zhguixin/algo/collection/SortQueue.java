package site.zhguixin.algo.collection;

import java.util.LinkedList;

// 单调队列: 依靠删除元素来保证有序性
// 实现O(1)获取最大值得单调队列
public class SortQueue<T extends Comparable> {

    LinkedList<T> cache = new LinkedList<>();

    public void put(T val) {
        while (!cache.isEmpty() && val.compareTo(cache.getLast()) > 0) {
            cache.removeLast();
        }
        cache.addLast(val);
    }

    public T max() {
        return cache.getFirst();
    }

    public void remove(T val) {
        if (!cache.isEmpty() && cache.getFirst() == val) {
            cache.removeFirst();
        }
    }

    // 利用单调队列求滑动窗口里的最大值
    public void maxSlidingWindow(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {// 前k-1个元素塞到单调队列里
                putInt(nums[i]);
            } else {// 滑动窗口已经覆盖
                putInt(nums[i]);
                print();
                System.out.println(maxInt());
                removeInt(nums[i - (k-1)]);
            }
        }
    }


    LinkedList<Integer> cacheInt = new LinkedList<>();
    public void putInt(Integer val) {
        while (!cacheInt.isEmpty() && val > cacheInt.getLast()) {
            cacheInt.removeLast();
        }
        cacheInt.addLast(val);
    }

    public Integer maxInt() {
        return cacheInt.getFirst();
    }

    public void removeInt(Integer i) {
        // 要移除的是最大元素才能移除成功, 此处为了保证能从滑动窗口中的所有元素能立即获取最大值(最大值在头部由put方法保证)
        if (!cacheInt.isEmpty() && i.equals(cacheInt.getFirst())) {
            cacheInt.removeFirst();
        }
    }

    public void print() {
//        System.out.println("cache size=" + cacheInt.size());
        for (Integer integer : cacheInt) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SortQueue sortQueue = new SortQueue();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        sortQueue.maxSlidingWindow(nums, 3);
    }
}

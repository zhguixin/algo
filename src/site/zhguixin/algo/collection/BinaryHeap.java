package site.zhguixin.algo.collection;

import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>> {
//    PriorityQueue queue = new PriorityQueue();
    // 存储数组元素
    private T[] pq;
    // 当前数组中存放的元素个数
    private int N = 0;

    public BinaryHeap(int cap) {
        // 数组下标为0的元素不存放值
        pq = (T[]) new Comparable[cap + 1];
    }

    /**
     * 对外提供的插入接口
     * @param val 待插入的元素
     */
    public void insert(T val) {
        // 数组长度加一
        N++;
        // 把插入的元素放到最后
        pq[N] = val;
        // 上浮这个元素
        swim(N);
    }

    /**
     * 对外提供的删除最大元素的接口
     * @return 返回最大元素
     */
    public T deleteMax() {
        // 堆顶元素即为最大
        T max = pq[1];
        // 把堆顶元素换到最底部
        exchange(1, N);
        // 底部元素置空
        pq[N] = null;
        N--;
        // 把(刚才在底部)换到堆顶的元素下沉到正确位置
        sink(1);
        return max;
    }

    // 上浮第k个元素，以维护最大堆的性质
    private void swim(int k) {
        // 上浮的条件是: 第k个元素不在堆顶 并且 第k个元素的父节点小于第k个元素
        while (k > 1 && less(parent(k), k)) {
            // 把父节点和子节点交换
            exchange(parent(k), k);
            // k节点上浮
            k = parent(k);
        }
    }

    // 下沉第k个元素,以维护最大堆的性质
    private void sink(int k) {
        // 下沉的条件是: 没有下沉到最底部
        while (left(k) <= N) {
            // 先假设左边的元素大
            int older = left(k);
            // 如果右边节点存在 并且 左边节点小于右边节点
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            // 如果最大的节点都比父节点小，那就不需要下沉了
            if (less(older, k)) break;
            exchange(older, k);
            k = older;
        }
    }

    // pq[i]是否比pq[j]小
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    // 父节点的索引
    private int parent(int root) {
        return root / 2;
    }

    // 左孩子的索引
    private int left(int root) {
        return root * 2;
    }

    // 右孩子的索引
    private int right(int root) {
        return root * 2 + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(pq);
    }
}

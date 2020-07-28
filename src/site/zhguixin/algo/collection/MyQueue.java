package site.zhguixin.algo.collection;

// 用数组实现一个队列
public class MyQueue {

    private String[] queue;
    private int size = 0;
    private int maxIndex;
    private int head, tail;

    public MyQueue(int maxCap) {
        queue = new String[maxCap];
        // 头尾指针从-1开始, 放入数据之前加一
        head = tail = -1;
        maxIndex = maxCap - 1;
    }

    public void offer(String str) {
        if (size >= queue.length) {
            return;
        }

        size++;
        tail++;
        if (tail > maxIndex) {
            tail = 0;
        }
        queue[tail] = str;
    }

    public String get() {
        if (size <= 0) {
            return null;
        }
        size--;
        head++;
        if (head > maxIndex) {
            maxIndex = 0;
        }

        String res = queue[head];
        queue[head] = null;
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        MyQueue myQueue = new MyQueue(4);
        myQueue.offer("1");myQueue.offer("2");myQueue.offer("3");myQueue.offer("4");
        myQueue.get();
        myQueue.offer("5");// 此时的5被插到了数组头部
        for (String str : myQueue.queue) {
            System.out.println(str);
        }
    }
}

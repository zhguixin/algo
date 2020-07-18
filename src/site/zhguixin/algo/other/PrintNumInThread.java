package site.zhguixin.algo.other;

public class PrintNumInThread {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        PrintNumInThread printNumInThread = new PrintNumInThread();
        printNumInThread.print(10);
        while (true) {

        }
    }

    private static final Object LOCK = new Object();
    private volatile int i = 1;

    // 使用两个线程交替打印 1~N的奇数和偶数
    public void print(int N) {

        // 奇数
        Thread oddThread = new Thread(() -> {
            while (true) {
                synchronized (LOCK) {
                    if (i >= N) {
                        break;
                    }
                    // 当前在打印偶数, 自旋等待
                    while (i % 2 == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread name=" + Thread.currentThread().getName() + ":i=" + i);
                    i++;
                    LOCK.notifyAll();
                }
            }
        });
        oddThread.setName("odd_thread");

        // 奇数
        Thread evenThread = new Thread(() -> {
            while (true) {
                synchronized (LOCK) {
                    if (i >= N) {
                        break;
                    }
                    // 当前在打印奇数, 自旋等待
                    while (i % 2 == 1) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread name=" + Thread.currentThread().getName() + ":i=" + i);
                    i++;
                    LOCK.notifyAll();
                }
            }
        });
        evenThread.setName("even_thread");

        oddThread.start();
        evenThread.start();
    }
}

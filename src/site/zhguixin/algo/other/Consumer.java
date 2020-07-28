package site.zhguixin.algo.other;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

class Consumer {


//    LinkedBlockingQueue
    private LinkedList<String> storeList;

    public Consumer(LinkedList<String> list) {
        this.storeList = list;
    }

    public void consume() {
        synchronized (storeList) {

            // 队列为空时, 自旋等待
            while (storeList.isEmpty()) {
                try {
                    storeList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 队列里有数据就全部取出来
            while (!storeList.isEmpty()) {
                System.out.println(storeList.remove());
            }
            storeList.notifyAll();
        }
    }
}

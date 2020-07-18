package site.zhguixin.algo.other;

import java.util.LinkedList;

class Producer {

    private LinkedList<String> storeList;
    private int cap;

    public Producer(LinkedList<String> list, int cap) {
        this.storeList = list;
        this.cap = cap;
    }

    public void produce(String p) {
        synchronized (storeList) {
            // 队列满时, 自旋等待
            while (storeList.size() >= cap) {
                try {
                    storeList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 模拟先生产两个商品
            storeList.add(p);
            storeList.notifyAll();
        }
    }
}

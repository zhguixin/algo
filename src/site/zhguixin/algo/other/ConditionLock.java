package site.zhguixin.algo.other;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionLock {

    private ReentrantLock lock = new ReentrantLock();
    // 队列没有满
    private Condition notFull = lock.newCondition();
    // 队列没有空
    private Condition notEmpty = lock.newCondition();

    private LinkedList<String> queue = new LinkedList<>();
    private int MAX = 10;

    public void produce(String str) {

        lock.lock();
        try {
            while (queue.size() >= MAX) {
                // 释放锁, 加入等待队列，AQS中维护了一个等待队列
                notFull.await();
            }
            queue.add(str);
            notEmpty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            System.out.println(queue.remove());
            notFull.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

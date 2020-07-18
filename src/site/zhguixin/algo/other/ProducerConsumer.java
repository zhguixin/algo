package site.zhguixin.algo.other;

import java.util.LinkedList;
import java.util.List;

// 生产者消费者模式
public class ProducerConsumer {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkedList<String> linkedList = new LinkedList<>();
        Producer producer = new Producer(linkedList, 5);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                producer.produce("1");
                producer.produce("2");
            }
        });

        Consumer consumer = new Consumer(linkedList);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.consume();
            }
        });
        thread2.start();

        try {
            Thread.sleep(1000);
            thread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {

        }
    }


}

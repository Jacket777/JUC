package com.thread.basic01.c31;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 线程协作2--生产者与消费者模式
 * 15-3
 */
public class T02_Producer_Consumer {
    /**
     * 15-13 生产者消费者协作队列
     * @param <E>
     */
    static class MyBlockingQueue<E>{
        private final Queue<E> queue ;
        private final int limit; //队列的长度

        public MyBlockingQueue(int limit){
            this.limit = limit;
            queue = new ArrayDeque<>(limit);
        }

        public synchronized void put(E e) throws InterruptedException {
            while(queue.size() == limit){
                wait();
            }
            queue.add(e);
            notifyAll();
        }

        public synchronized E take()throws InterruptedException{
            while(queue.isEmpty()){
                wait();
            }
            E e = queue.poll();
            notifyAll();
            return e;
        }
    }


    /**
     * 简单消费者
     */
    static class Producer extends Thread{
        MyBlockingQueue<String>queue;

        public Producer(MyBlockingQueue<String>queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            int num = 0;
            try{
                while(true){
                    String task = String.valueOf(num);
                    queue.put(task);
                    System.out.println("produce task "+task);
                    num++;
                    Thread.sleep((int)(Math.random()*100));
                    // Thread.sleep(3000);

                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 15-15 简单消费者
     */
    static class Consumer extends Thread {
        MyBlockingQueue<String> queue;

        public Consumer(MyBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {

                    String task = queue.take();
                    System.out.println("handle task " + task);
                    Thread.sleep((int) (Math.random() * 100));
                    //Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<String>queue = new MyBlockingQueue<>(10);
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}

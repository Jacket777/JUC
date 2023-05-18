package com.thread.basic01.c31;

/**
 * 线程协作---等待结束
 * 15-20 使用MyLatch实现同时开始
 */
public class T05_MyLatch {
    /**
     * 15-18 协作对象MyLatch
     */
    static class MyLatch{
        private int count;
        public MyLatch(int count){
            this.count = count;
        }

        public synchronized void await()throws InterruptedException{
            while(count>0){
                wait();
            }
        }

        public synchronized void countDown(){
            count--;
            if(count<=0){
                notifyAll();
            }
        }
    }

    static class Racer extends Thread{
        MyLatch latch;
        public Racer(MyLatch latch)  {
              this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+" ready");
                this.latch.await();
                System.out.println(Thread.currentThread().getName()+" finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        MyLatch latch = new MyLatch(1);
        Thread[]racers = new Thread[num];
        for (int i = 0; i < num ; i++) {
            racers[i] = new Racer(latch);
            racers[i].start();
        }
        Thread.sleep(5000);
        latch.countDown();
        System.out.println("collect work result");


    }



}

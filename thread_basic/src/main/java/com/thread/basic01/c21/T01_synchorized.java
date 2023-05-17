package com.thread.basic01.c21;

/**
 * 15-5 多线程访问synchornized包含的对象
 */
public class T01_synchorized {
    private static class Counter{
        private int count;
        public synchronized void incr() throws InterruptedException {
            System.out.println("thread name: "+Thread.currentThread().getName());
          //
            count++;
            Thread.sleep(1000);
        }

        public synchronized int getCount(){
            return count;
        }
    }


    static class CounterThread extends Thread{
        Counter counter;
        public CounterThread(Counter counter){
            this.counter = counter;
        }

        @Override
        public void run() {


            for (int i = 0; i < 1000; i++) {

                try {
                    counter.incr();
                    //Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("thread name: "+Thread.currentThread().getName()+ " state: "+Thread.currentThread().getState());
        }
    }


    public static void main(String[] args) throws InterruptedException{
        int num = 1000;
        Counter counter = new Counter();
        Thread[]threads = new Thread[num];
        for (int i = 0; i < num ; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }

        for (int i = 0; i < num ; i++) {
            threads[i].join();

        }

        System.out.println(counter.getCount());

    }
}

package com.thread.basic01.c21;

/**
 * 15-6 多线程访问synchornized修饰静态方法
 */
public class T03_synchorizedClass {
    private static class Counter{
        private static int count;
        public synchronized static void incr() throws InterruptedException {
           // System.out.println("thread name: "+Thread.currentThread().getName());
          //
            count++;
            Thread.sleep(1000);
        }

        public synchronized static int getCount(){
            return count;
        }
    }


    static class CounterThread extends Thread{



        @Override
        public void run() {


            for (int i = 0; i < 10; i++) {

                try {
                    Counter.incr();
                    //Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

           // System.out.println("thread name: "+Thread.currentThread().getName()+ " state: "+Thread.currentThread().getState());
        }
    }


    public static void main(String[] args) throws InterruptedException{
        int num = 10;
        Thread[]threads = new Thread[num];
        for (int i = 0; i < num ; i++) {
            threads[i] = new CounterThread();
            threads[i].start();
        }

        for (int i = 0; i < num ; i++) {
            threads[i].join();
        }

        System.out.println(Counter.getCount());

    }
}

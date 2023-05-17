package com.thread.basic01;

/**
 * 2. 线程是为Daemon的区别
 *  默认为true 所有线程结束时 它会退出
 *  设置为false时，只有等到它自己结束才会退出
 *
 */
public class T03_DaemonThread {
   public static class HelloThread implements Runnable{
        @Override
        public void run(){
            while(true){
                System.out.println("thread name: "+Thread.currentThread().getName()+" thread priority "+Thread.currentThread().getPriority());
                System.out.println("thread name: "+Thread.currentThread().getName()+" thread state "+Thread.currentThread().getState());
                System.out.println("Hello");
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t  = new Thread(new HelloThread()," A");
       // t.setDaemon(false);
        t.start();

        System.out.println("..main end.." );

    }
}

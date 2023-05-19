package com.thread.basic01.c43;

/**
 * 说明：
 * 线程在运行中，并且没有执行IO操作，interrput只是会设置线程的中断标志
 * 不会有其他作用
 */
public class InterruptRunnableDemo extends Thread{
    @Override
    public void run() {
        //case 1 比较好的做法--加判断
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("running");
        }
        System.out.println("done");
        //设置  t.interrupt(); 后，程序仍然正常运行
//        while(true){
//            System.out.println("running");
//        }

    }

    public static void main(String[] args) throws InterruptedException {
        InterruptRunnableDemo t = new InterruptRunnableDemo();
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}

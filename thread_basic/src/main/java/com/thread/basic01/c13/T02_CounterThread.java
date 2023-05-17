package com.thread.basic01.c13;

/**
 * 15-2 race condition exemple
 * 竞态条件实例
 * 解决方法：
 * 1.使用synchronized关键字
 * 2.使用显示锁
 * 3.使用原子变量
 */
public class T02_CounterThread extends Thread{
    private static int counter = 0;
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            counter++; //它不是原子操作
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int num = 1000;
        Thread[]threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new T02_CounterThread();
            threads[i].start();
        }

        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter);
    }

}

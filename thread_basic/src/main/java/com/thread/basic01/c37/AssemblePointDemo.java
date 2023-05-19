package com.thread.basic01.c37;

/**
 * 15-25 集合协作实例
 */
public class AssemblePointDemo {
    static class Tourist extends Thread{
        AssemblePoint ap;
        public Tourist(AssemblePoint ap){
            this.ap = ap;
        }

        @Override
        public void run() {

            try {
                System.out.println(Thread.currentThread().getName()+" running");
                //模拟游客各自独立运行
                Thread.sleep((int)(Math.random()*1000));
                //集合
                ap.await();
                System.out.println(Thread.currentThread().getName()+" arrived");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int num = 2;
        Tourist[]threads = new Tourist[num];
        AssemblePoint ap = new AssemblePoint(num);
        for (int i = 0; i < num; i++) {
            threads[i] = new Tourist(ap);
            threads[i].start();
        }
    }
}

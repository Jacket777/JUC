package com.thread.basic01.c31;

/**
 * 线程协作 同时开始
 */
public class T03_concurrent {
    /**
     * 15-16 协作对象
     */
    static class FireFlag{
        private volatile boolean fired = false;

        public synchronized void waitForFire()throws InterruptedException{
            while(!fired){
                wait();
            }
        }

        public synchronized void fire(){
            this.fired = true;
            notifyAll();
        }
    }

    /**
     * 15-17 表示比赛运动员的类
     */
    static class Racer extends Thread{
        FireFlag fireFlag;
        public Racer(FireFlag fireFlag){
            this.fireFlag = fireFlag;
        }

        @Override
        public void run() {
            try {
                System.out.println("start  "+Thread.currentThread().getName());
                this.fireFlag.waitForFire();
                System.out.println("start run "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        FireFlag fireFlag = new FireFlag();
        Thread[]racer = new Thread[num];
        for (int i = 0; i < num; i++) {
            racer[i] = new Racer(fireFlag);
            racer[i].start();
        }
        Thread.sleep(5000);
        fireFlag.fire();
    }
}

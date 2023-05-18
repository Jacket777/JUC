package com.thread.basic01.c31;

/**
 * 15-12 简单协作实例
 * notify  wait方法只能在synchronized代码内部被调用
 * 如果没有则抛出IllegalMonitorStateException
 */
public class T01_WaitThread extends Thread{
    private volatile boolean fire = false;
    @Override
    public void run() {
        synchronized (this){
            while(!fire){
                try {
                    System.out.println("wait fire....");
                    wait();
                    System.out.println("wait end....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        }


    public synchronized void fire(){
        this.fire = true;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        T01_WaitThread waitThread = new T01_WaitThread();
        waitThread.start();

        Thread.sleep(9000);
        System.out.println("fire");
        waitThread.fire();
    }
    }


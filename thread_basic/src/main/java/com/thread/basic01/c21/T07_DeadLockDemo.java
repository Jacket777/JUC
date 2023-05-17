package com.thread.basic01.c21;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 死锁程序实例
 */
public class T07_DeadLockDemo {
    public static Object lockA = new Object();
    public static Object lockB = new Object();

    private static void startThreadA(){
        Thread aThread = new Thread(()->{
            synchronized (lockA){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB){
                    System.out.println("---thread A--");
                }
            }
        });
        aThread.start();
    }

    private static void startThreadB(){
        Thread bThread = new Thread(()->{
            synchronized (lockB){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA){
                    System.out.println("---thread B--");
                }
            }
        });
        bThread.start();
    }

    public static void main(String[] args) {
        startThreadA();
        startThreadB();
        testThread();
    }


    /**
     * 查看死锁状态
     */
    public static void testThread(){
        boolean isRun = true;
        while(isRun){
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
           // long[]threadIds = threadMXBean.findMonitorDeadlockedThreads();
            // long[]threadIds = threadMXBean.findDeadlockedThreads();
            long[]threadIds = threadMXBean.getAllThreadIds();
            //System.out.println(threadIds.length);

            if(threadIds.length >6){
                ThreadInfo[] infos = threadMXBean.getThreadInfo(threadIds);
                System.out.println("以下为线程程资源");
                for (ThreadInfo info:infos) {
                    if(info.getThreadName().contains("Thread")){
                        System.out.println(info.getThreadId()+" "+info.getThreadName()+" state:"+info.getThreadState()+"  "+ info.getBlockedCount());
                        //info.getLockOwnerName() 获取锁当前所属线程名字
                       // System.out.println(info.getThreadId()+" "+info.getThreadName()+" state:   "+info.getLockInfo()+" ");
                    }

                }
                System.out.println("=================================");
            }else{
                System.out.println("------->>>>>------");
                isRun = false;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}

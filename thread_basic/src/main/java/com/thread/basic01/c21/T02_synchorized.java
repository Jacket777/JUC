package com.thread.basic01.c21;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;

/**
 * 扩展程序--检查线程的各类状态
 * RUNNABLE
 * TIMED_WAITING
 * BLOCKED
 * TERMINATED
 *
 */
public class T02_synchorized {
    private static class Counter{
        private int count;
        public synchronized void incr() throws InterruptedException {
            //System.out.println("thread name: "+Thread.currentThread().getName()+" beginning");
            count++;
            Thread.sleep(5000);
          //  System.out.println("thread name: "+Thread.currentThread().getName()+" end...");
        }

        public synchronized int getCount(){
            return count;
        }

        @Override
        public String toString() {
            return "Counter{" +
                    "count=" + "AAAAA" +
                    '}';
        }
    }


    static class CounterThread extends Thread{
        Counter counter;
        String name;
        public CounterThread(Counter counter,String name){
            this.name = name;
            this.counter = counter;
        }

        @Override
        public void run() {
            try {
                counter.incr();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         //   System.out.println("thread name: "+name+ " state: "+Thread.currentThread().getState());
        }
    }


    public static void main(String[] args) throws InterruptedException{
        int num = 5;
        Counter counter = new Counter();
       // Lock lock = (Lock)counter;
        Thread t1 = new T02_synchorized.CounterThread(counter,"A");
        Thread t2 = new T02_synchorized.CounterThread(counter,"B");
        Thread t3 = new T02_synchorized.CounterThread(counter,"C");
        Thread t4 = new T02_synchorized.CounterThread(counter,"D");
        Thread []ts = {t1,t2,t3,t3};
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.sleep(1000);
       // testThread();
        test(ts);
        //
        t1.join();

        t2.join();
        t3.join();
        t4.join();

        System.out.println(counter.getCount());

    }

    /**
     * 检测运行的线程状态
     * @param ts 线程组
     * @throws InterruptedException  抛出异常
     */
    public static void test(Thread[]ts) throws InterruptedException {
        while(true){
            boolean isAlive = false;
            System.out.println("----------------------------");
            for(Thread t:ts){
                System.out.println(t.getName()+" "+t.getState());
            }

            for(Thread t:ts){
                if(t.getState()!=Thread.State.TERMINATED) {
                    isAlive = true;
                    break;
                }
            }

            if(!isAlive){
                break;
            }
            Thread.sleep(2000);
        }
    }

   //注解掉的方法--有问题
    public static void testThread(){
        boolean isRun = true;
        while(isRun){
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
          //  long[]threadIds = threadMXBean.findMonitorDeadlockedThreads();
          //  long[]threadIds = threadMXBean.findDeadlockedThreads();
            long[]threadIds = threadMXBean.getAllThreadIds();
            //System.out.println(threadIds.length);

            if(threadIds.length >6){
                ThreadInfo[] infos = threadMXBean.getThreadInfo(threadIds);
                System.out.println("以下为线程程资源");
                for (ThreadInfo info:infos) {
                    if(info.getThreadName().contains("Thread")){
                        System.out.println(info.getThreadId()+" "+info.getThreadName()+" state:"+info.getThreadState()+"  "+ info.getBlockedCount());
                        //info.getLockOwnerName() 获取锁当前所属线程名字
                        System.out.println(info.getThreadId()+" "+info.getThreadName()+" state:   "+info.getLockInfo()+" ");
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

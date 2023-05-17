package com.thread.basic01.c13;

import java.util.ArrayList;
import java.util.List;

/**
 * 15-1
 * 共享内存实例
 * Note:
 * 1. 程序中有三条执行流，一条执行main方法，另外两条执行ChildThread的run方法
 * 2. 不同的执行流可以访问和操作相同的变量
 * 3.不同的执行流可以执行相同的代码
 * 4. 当多条执行流执行相同程序代码时，每条执行流都有单独的栈,方法中的参数和局部变量都有自己的一份
 */
public class T01_ShareMemoryDemo {
    private static int shared = 0;
    private static void incrShared(){
        shared++;
    }


    public static class ChildThread extends Thread{
        List<String> list;

        public ChildThread(List<String>list){
            this.list = list;

        }

        @Override
        public void run(){
            incrShared();
            list.add(Thread.currentThread().getName());
        }

    }


    public static void main(String[] args)throws InterruptedException {
        List<String>list = new ArrayList< >();
        Thread t1 = new ChildThread(list);
        Thread t2 = new ChildThread(list);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(shared);
        System.out.println(list);
    }
}

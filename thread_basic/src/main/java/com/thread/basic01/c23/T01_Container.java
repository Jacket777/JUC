package com.thread.basic01.c23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 15-11 同步容器迭代问题
 */
public class T01_Container {


    private static void startModifyThread(final List<String> list){
        Thread modifyThread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                list.add("item "+i);
                try {
                    Thread.sleep((int)(Math.random()*10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        modifyThread.start();
    }


    private static void startIteratorThread(final List<String> list){
        Thread iteratorThread = new Thread(()->{
               while(true){
                   //会发生异常
//                   for (String str:list) {
//                       System.out.println(str);
//                   }
                   //容器对象加锁
               synchronized (list){
                   for (String str:list) {
                       System.out.println(str);
                   }
               }
               }
        });
        iteratorThread.start();
    }

    public static void main(String[] args) {
        final List<String>list = Collections.synchronizedList(new ArrayList<>());
        startIteratorThread(list);
        startModifyThread(list);
    }


}

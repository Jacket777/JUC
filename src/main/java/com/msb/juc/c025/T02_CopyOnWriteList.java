package com.msb.juc.c025;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class T02_CopyOnWriteList {

	public static void main(String[] args) {
		List<String>lists = new CopyOnWriteArrayList<>();
        Random r = new Random();
        Thread[]ths = new Thread[100];
        for(int i =0; i < ths.length; i++) {
        	Runnable task = new Runnable() {
        		@Override
        		public void run() {
        		for(int j = 0; j <10000; j++) {
            		lists.add("a"+r.nextInt(1000000));
            		   }
        		}
        	};
        	ths[i] = new Thread(task);
           }
        
         runAndComputeTime(ths);
         System.out.println(lists.size()); 
	}
	
	
	
	static void runAndComputeTime(Thread[]ths) {
		long s1 = System.currentTimeMillis();
		Arrays.asList(ths).forEach(t->t.start());
		Arrays.asList(ths).forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long s2 = System.currentTimeMillis();
		System.out.println(s2-s1);
	}

}

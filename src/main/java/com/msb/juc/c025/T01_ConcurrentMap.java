package com.msb.juc.c025;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class T01_ConcurrentMap {

	public static void main(String[] args) {
           Map<String, String>map =  new ConcurrentHashMap<>();
           Random r = new Random();
           Thread[]ths = new Thread[100];
           CountDownLatch latch = new CountDownLatch(ths.length);
           long start = System.currentTimeMillis();
           for(int i =0; i < ths.length; i++) {
        	   ths[i] = new Thread(()->{
        		   for(int j = 0; j <10000; j++) {
        			   map.put("a"+r.nextInt(1000000), "a"+r.nextInt(1000000));
        		   }
        		   latch.countDown();
        		   
        		   
        		   
        		   
        	   });
           }
           Arrays.asList(ths).forEach(t->t.start());
           try {
        	   latch.await();  
           }catch(InterruptedException e) {
        	   e.printStackTrace();
           }
          
           
           
           long end = System.currentTimeMillis();
           System.out.println(end - start);
           System.out.println(map.size());
	}

}

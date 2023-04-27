package com.msb.juc.c026;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T04_00_BlockingQueue {
	static BlockingQueue<String>q1 = new ArrayBlockingQueue(1);
	static BlockingQueue<String>q2 = new ArrayBlockingQueue(1);

	


	public static void main(String[] args) {		
        char[]aI = "1234567".toCharArray();
        char[]aC = "ABCDEFG".toCharArray();
        

         
         new Thread(()->{
             	  for(char c: aI) {
             		 System.out.print(c);
             		 try {
             			 q1.put("ok");
             			 q2.take();
             		 }catch(InterruptedException e) {
             			 e.printStackTrace();
             		 }
        
             	  }	
	     },"t1").start();
         
         new Thread(()->{
        	  for(char c: aC) {
        		  try {
					q1.take();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
        		  
        		  
        		 System.out.print(c);
        		 try {
        			 q2.put("ok");
        			
        		 }catch(InterruptedException e) {
        			 e.printStackTrace();
        		 }
   
        	  }	
    },"t1").start();
         
	}

}

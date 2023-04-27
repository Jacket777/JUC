package com.msb.juc.c026;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T13_TransferQueue {
	static BlockingQueue<String>q1 = new ArrayBlockingQueue(1);
	static BlockingQueue<String>q2 = new ArrayBlockingQueue(1);

	


	public static void main(String[] args)throws Exception {		
        char[]aI = "1234567".toCharArray();
        char[]aC = "ABCDEFG".toCharArray();
        TransferQueue<Character>queue = new LinkedTransferQueue<Character>();
        
     
      
         new Thread(()->{
        	 byte[]buffer = new byte[9];
        	 try {
        	 	  for(char c: aI) {
        	 		 System.out.print(queue.take());
        	 		 queue.transfer(c);

              	  }	
        	 }catch(Exception e) {
        		 e.printStackTrace();
        	 }
            
	     },"t1").start();
         
         new Thread(()->{
        	 try {
        	 	  for(char c: aC) {
        	 		 queue.transfer(c);

        	 		 System.out.print(queue.take());
        	 		 
              	  }	
        	 }catch(Exception e) {
        		 e.printStackTrace();
        	 }
            
	     },"t2").start();
         
	}

}

package com.msb.juc.c026;

import java.util.concurrent.locks.LockSupport;

public class T06_00_sync_wait_notify {
	

	public static void main(String[] args) {
		final Object o = new Object();
		
        char[]aI = "1234567".toCharArray();
        char[]aC = "ABCDEFG".toCharArray();
         
         
        new Thread(()->{
        	synchronized(o) {
           	 for(char c: aI) {
        		 System.out.print(c);
        	     
        	     try {
        	    	o.notify();
					o.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
           	 o.notify();
        	}
    
    
	     },"t1").start();
         
        new Thread(()->{
        	synchronized(o) {
           	 for(char c: aC) {
        		 System.out.print(c);
        	     
        	     try {
        	    	o.notify();
					o.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
           	 o.notify();
        	}
    
    
	     },"t2").start();
         
 

}
}

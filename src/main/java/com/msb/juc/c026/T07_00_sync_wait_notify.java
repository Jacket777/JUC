package com.msb.juc.c026;

import java.util.concurrent.locks.LockSupport;

public class T07_00_sync_wait_notify {
	private static volatile boolean t2Started = false;

	public static void main(String[] args) {
		
		final Object o = new Object();
		
        char[]aI = "1234567".toCharArray();
        char[]aC = "ABCDEFG".toCharArray();
         
         
        new Thread(()->{
        	synchronized(o) {
        		while(!t2Started) {
        			try {
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
        		}
        		
        		
        		
        		
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
        		 t2Started = true;
        	     
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

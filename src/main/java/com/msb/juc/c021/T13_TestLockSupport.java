package com.msb.juc.c021;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T13_TestLockSupport {

	public static void main(String[] args) {
           Thread t = new Thread(()->{
        	   for(int i = 0; i< 10; i++) {
        		   System.out.println(i);
        		   if(i == 5) {
        			   LockSupport.park();
        		   }
        		   
        		   try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

        	   }
           });
           t.start();
           //
	}

}

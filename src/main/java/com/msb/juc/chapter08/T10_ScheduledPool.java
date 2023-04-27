package com.msb.juc.chapter08;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class T10_ScheduledPool {

	public static void main(String[] args) {
         ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
         service.scheduleAtFixedRate(()->{
        	 try {
				TimeUnit.MICROSECONDS.sleep(new Random().nextInt(10000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 System.out.println(Thread.currentThread().getName());
        	 
        	 
         }, 0, 500, TimeUnit.MICROSECONDS);
         
	}

}

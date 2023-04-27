package com.msb.juc.c000;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


/**
 * 启动线程的三种方式
 * 1.Thread  2.Runnable  3.Executors.newCachedThread
 */

public class T02_HowToCreateThread {
	static class MyThread extends Thread{
		@Override
		public void run() {
			System.out.println("Hello MyThread");
			
		}
	}
	
	
	
	
	static class MyRun implements Runnable{

		@Override
		public void run() {
           System.out.println("Hello MyRun!");			
			
		}

		
	}
	
	
	
	
	static class MyCall implements Callable<String>{

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			System.out.print("Hello MyCall");
			return "success";
		}
		
	}

	public static void main(String[] args) {
       new MyThread().start();
       new Thread(new MyRun()).start();
       //lambda 表达式
       new Thread(()-> {
    	   System.out.println("hello lambda");
       }).start();
       
       
       Thread t = new Thread(new FutureTask<String>(new MyCall()));
       t.start();
       
       
       ExecutorService service = Executors.newCachedThreadPool();
       service.execute(()->{
    	   System.out.println("helllo threadpool");
       });
       service.shutdown();
	}

}

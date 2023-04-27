package com.msb.juc.chapter08;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class T14_MyRejectedHandler {

	public static void main(String[] args) {
		ExecutorService service = new ThreadPoolExecutor(4,4,0,TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(6),
				Executors.defaultThreadFactory(),
				new MyHandler()
				);

	}
	
	
	
	static class MyHandler implements RejectedExecutionHandler{

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			if(executor.getQueue().size()<10000) {
				
			}
			
			
		}
		
	}

}

package com.msb.juc.chapter08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class T09_FixedThreadPool {

	public static void main(String[] args) throws InterruptedException,ExecutionException{
           long start = System.currentTimeMillis();
           getPrime(1,200000);
           long end = System.currentTimeMillis();
           System.out.println(end- start);
           final int cpuCoreNum = 4;
           
           ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);
           
           MyTask t1 = new MyTask(1,800000);
           MyTask t2 = new MyTask(800001,1300000);
           MyTask t3 = new MyTask(1300001,1700000);
           MyTask t4 = new MyTask(1700001,2000000);
           
           Future<List<Integer>>f1 = service.submit(t1);
           Future<List<Integer>>f2 = service.submit(t2);
           Future<List<Integer>>f3 = service.submit(t3);
           Future<List<Integer>>f4 = service.submit(t4);
           
           start = System.currentTimeMillis();
           f1.get();
           f2.get();
           f3.get();
           f4.get();
           end = System.currentTimeMillis();
           System.out.println(end- start);
	}
	
	
	
	





	static class MyTask implements Callable<List<Integer>>{
		int startPos, endPos;
		MyTask(int s, int e){
			this.startPos = s;
			this.endPos = e;
		}

		@Override
		public List<Integer> call() throws Exception {
            List<Integer>r = getPrime(startPos, endPos);			
			return r;
		}	
	}
	
	
	
	static boolean isPrime(int num) {
		for(int i = 2; i <= num/2; i++) {
			return false;
		}
		
		return true;
	}
	
	
	
	static List<Integer> getPrime(int start, int end) {
		List<Integer>results = new ArrayList<>();
		for(int i = start;i <= end; i++) {
			if(isPrime(i)) {
				results.add(i);
			}
		}
		
		return results;
	}

}

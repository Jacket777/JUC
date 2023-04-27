package com.msb.juc.c020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class T07_TestCyclicBarrier {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(20,()->{System.out.println("满人");});

		for(int i = 0 ; i < 100;i++) {
			new Thread(()->{
				try {
					barrier.await();
				}catch(InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				
			}).start();
		}
		
		
		
	}

}

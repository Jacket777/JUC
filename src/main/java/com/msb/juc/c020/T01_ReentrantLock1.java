package com.msb.juc.c020;

import java.util.concurrent.TimeUnit;

public class T01_ReentrantLock1 {
	
	synchronized void m1() {
		for(int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
			if(i == 2)m2();
		}
		
	}
	
	synchronized void m2() {
		System.out.println("m2....");
	}
	
	
	
	
	public void main(String[]args){
		T01_ReentrantLock1 r1 = new T01_ReentrantLock1();
		new Thread(r1::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(r1::m2).start();
		
	}

}

package com.msb.juc.c020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T05_ReentrantLock5 extends Thread{
	private static ReentrantLock lock = new ReentrantLock(true);
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName()+"获得锁");
				
			}finally {
				lock.unlock();
			}
		}
	}
	
	public void main(String[]args){
		T05_ReentrantLock5 r = new T05_ReentrantLock5();
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		th1.start();
		th2.start();
	}

}

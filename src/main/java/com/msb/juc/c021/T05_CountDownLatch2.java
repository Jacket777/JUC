package com.msb.juc.c021;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class T05_CountDownLatch2 {
	volatile List lists = new ArrayList();
	public void add(Object o) {
		lists.add(o);
	}
	
	public int size() {
		return lists.size();
	}
	
	
	public static void main(String[] args) {
		T05_CountDownLatch2 c = new T05_CountDownLatch2();
		CountDownLatch latch = new CountDownLatch(1);
		new Thread(()->{
			System.out.println("t2 启动");
			if(c.size()!=5) {
				try {
					latch.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("t2 结束");	
		},"t2").start();
		
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(()->{
			System.out.println("t1 启动");
			for(int i = 0; i <10; i++) {
				c.add(new Object());
				System.out.println("add "+i);
				if(c.size()==5) {
					latch.countDown();
					
					try {
						latch.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		},"t1").start();
	}

}

package com.msb.juc.c021;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T07_LockSupport_WithOutSleep {
	volatile List lists = new ArrayList();
	public void add(Object o) {
		lists.add(o);
	}
	
	public int size() {
		return lists.size();
	}
	
	static Thread t1 = null, t2 = null;

	public static void main(String[] args) {
		T06_LockSupport c = new T06_LockSupport();
		CountDownLatch latch = new CountDownLatch(1);
	    t2 = 	new Thread(()->{
			System.out.println("t2 启动");
			if(c.size()!=5) {
				LockSupport.park();
			}
			System.out.println("t2 结束");	
		    LockSupport.unpark(t1);
		},"t2");
	
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	t1 = new Thread(()->{
			System.out.println("t1 启动");
			for(int i = 0; i <10; i++) {
				c.add(new Object());
				System.out.println("add "+i);
				if(c.size()==5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
				}
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		},"t1");
	  t2.start();
	  t1.start();
	}

}

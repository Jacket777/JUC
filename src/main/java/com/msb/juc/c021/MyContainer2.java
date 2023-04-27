package com.msb.juc.c021;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2 <T>{
	final private LinkedList<T>lists = new LinkedList<>();
	final private int MAX = 10;
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition producer = lock.newCondition();
	private Condition consumer = lock.newCondition();

	
	//生产者
	public synchronized void PUT(T t) {
		try {
			
		lock.lock();
		while(lists.size()==MAX) {
				producer.await();
			} 
		lists.add(t);
		++count;
		consumer.signalAll();
		
		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
		}	
	}
	
	
	//消费者
	public synchronized T get() {
		T t =  null;
		try {
			lock.lock();
			while(lists.size() ==0) {
		       consumer.await();
			}
			t = lists.removeFirst();
			count--;
			producer.signalAll();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return t;
	}
	
	
	

	public static void main(String[] args) {
       MyContainer2<String>c = new MyContainer2<>();
       //启动消费线程
       for(int i = 0; i < 10; i++) {
    	   new Thread(()->{
    		   for(int j  = 0; j<5; j++) {
    			   System.out.println(c.get());
    		   }
	   
    	   },"c"+i).start();
       }
       
       try {
		TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       
       //启动生产线程
       for(int i = 0; i < 2; i++) {
    	   new Thread(()->{
    		   for(int j  = 0; j<25; j++) {
    			   c.PUT(Thread.currentThread().getName()+" "+j);
    		   }
	   
    	   },"p"+i).start();
       }
       
       
	}

}

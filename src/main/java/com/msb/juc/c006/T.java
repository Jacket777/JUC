package com.msb.juc.c006;



public class T implements Runnable{
	private int count = 10;
	




	@Override
	public synchronized void run() {
      count--;
	  System.out.println(Thread.currentThread().getName()+" count = "+count);	
	}
	
	
	
	public static void main(String[] args) {		
         for(int i = 0; i<100; i++) {
        	T t = new T();
      	   new Thread(t,"THREAD"+ i).start();
         }
	}

}

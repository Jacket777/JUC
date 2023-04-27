package com.msb.juc.c004;

public class T {
	private static int count  = 10;
	
	public synchronized static void m() {
		count--;
		System.out.println(Thread.currentThread().getName()+" count = "+count);

	}
	
	
	
	public static void mm() {
		synchronized(T.class) {
			count--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

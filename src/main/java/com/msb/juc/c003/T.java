package com.msb.juc.c003;
/**
 * synchronzied 关键字
 * 对某个对象加锁
 * @author hu xiao qiang
 *
 */
public class T {
	private static int count = 10;
	
	public synchronized void m() {
		 //等同于在方法的代码执行时 要synchronized(this)
			count--;
			System.out.println(Thread.currentThread().getName()+" count = "+count);
		
	}
	
	
	
	
	
	public static void mm() {
		synchronized(T.class) {
			count--;
		}
	}

}

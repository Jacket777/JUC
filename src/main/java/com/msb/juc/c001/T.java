package com.msb.juc.c001;
/**
 * synchronzied 关键字
 * 对某个对象加锁
 * @author hu xiao qiang
 *
 */
public class T {
	private int count = 10;
	private Object o = new Object();
	
	public void m() {
		synchronized(o) { //任何线程想要执行下面的代码，必须拿到o的锁
			count--;
			System.out.println(Thread.currentThread().getName()+" count = "+count);
		}
	}

}

package com.msb.juc.c002;
/**
 * synchronzied 关键字
 * 对某个对象加锁
 * @author hu xiao qiang
 *
 */
public class T {
	private int count = 10;
	
	public void m() {
		synchronized(this) { //任何线程想要执行下面的代码 必须拿到this的锁
			count--;
			System.out.println(Thread.currentThread().getName()+" count = "+count);
		}
	}

}

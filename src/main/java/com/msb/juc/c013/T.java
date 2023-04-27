package com.msb.juc.c013;

/**
 * volatile 并不能保证多个线程共同修改变量时所带来的不一致性问题，
 * volatile不能替代synchronized
 */

import java.util.ArrayList;
import java.util.List;


public class T {
	volatile  int count = 0;
	void m() {
		for(int i  = 0; i <10000; i++) {
			count++;
		}
	}

	public static void main(String[] args) {
            T t = new T();
            List<Thread>threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(t::m,"thread-"+i));
		}

		threads.forEach((o)->o.start());
            

		threads.forEach((o)->{
            		try {
						o.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	});
            	System.out.println(t.count);
            }
            
            
	}



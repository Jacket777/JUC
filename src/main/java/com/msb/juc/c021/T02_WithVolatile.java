package com.msb.juc.c021;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T02_WithVolatile {
	volatile List lists = new ArrayList();
	
	public void add(Object o) {
		lists.add(o);
	}
	
	
	public int size() {
		return lists.size();
	}

	public static void main(String[] args) {
		T02_WithVolatile c = new T02_WithVolatile();
		new Thread(()-> {
			for(int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add "+i);
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		},"t1").start();
		
		
		
		new Thread(()-> {
			while(true) {
				if(c.size()==5) {
					break;
				}
			}
			System.out.println("t2 end!");
			
			
		},"t2").start();
	}

}

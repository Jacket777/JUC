package com.msb.juc.c012;

import java.util.concurrent.TimeUnit;

public class T01_HelloVolatile {
	volatile boolean running = true;
	
	void m() {
		System.out.println("m start");
		while(running) {
			
		}
		System.out.println("m end!");
	}
	
	
	
	
	

	public static void main(String[] args) {
		T01_HelloVolatile t = new T01_HelloVolatile();
		new Thread(t::m,"t1").start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        t.running =  false;
	}

}

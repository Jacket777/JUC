package com.msb.juc.c000;

public class T04_ThreadState {
	static class MyThread extends Thread{
		@Override
		public void run() {
			System.out.println("state: "+ this.getState());
			
			for(int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
			
			
		}
	}
	
	public static void main(String[]args){
		Thread t = new MyThread();
		System.out.println(t.getState());
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(t.getState());
		
	}

}

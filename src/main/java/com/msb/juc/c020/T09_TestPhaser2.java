package com.msb.juc.c020;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class T09_TestPhaser2 {
	static Random r = new Random();
	static MarriagePhaser phaser = new MarriagePhaser();
	
	static void milliSleep(int milli)  {
		try {
			TimeUnit.MICROSECONDS.sleep(milli);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		phaser.bulkRegister(7);
		for(int i = 0; i < 5; i++) {
			new Thread(new Person("p "+i)).start();
		}
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
		
		
	}
	
	static class MarriagePhaser extends Phaser{
		@Override
		protected boolean onAdvance(int phase, int registeredParties) {
			switch(phase) {
			case 0:
				System.out.println("所有人都到起了! "+registeredParties);
				System.out.println();
				return false;
			case 1:
				System.out.println("所有人都吃完! "+registeredParties);
				System.out.println();
				return false;
			case 2:
				System.out.println("所有人都离开! "+registeredParties);
				System.out.println();
				return false;
			case 3:
				System.out.println("婚礼结束！ 新郎新娘抱抱! "+registeredParties);
				System.out.println();
				return false;
			default:
				return true;
			}
		}
		
	}
	
	
	static class Person implements Runnable{
		String name;
		
		public Person(String name) {
			this.name = name;
		}
		
		public void arrive() {
			milliSleep(r.nextInt(1000));
			System.out.printf("%s 到达现场！ \n", name);
			phaser.arriveAndAwaitAdvance();
		}
		
		public void eat() {
			milliSleep(r.nextInt(1000));
			System.out.printf("%s 到达现场！ \n", name);
			phaser.arriveAndAwaitAdvance();
		}
		
		public void leave() {
			milliSleep(r.nextInt(1000));
			System.out.printf("%s 到达现场！ \n", name);
			phaser.arriveAndAwaitAdvance();
		}
		
		
		private void hug() {
			if(name.equals("新郎")||name.equals("新娘")) {
				milliSleep(r.nextInt(1000));
				System.out.printf("%s 洞房！ \n", name);
				phaser.arriveAndAwaitAdvance();

			}else {
				phaser.arriveAndDeregister();
			}
			
			
		}
		
		
		
		

		@Override
		public void run() {
             arrive();
             eat();
             leave();
             hug();
			
		}
		
	}

}

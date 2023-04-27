package com.msb.juc.c026;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class T06_01_CompletableFuture {

	public static void main(String[] args) throws InterruptedException,ExecutionException{
		// TODO Auto-generated method stub
		long start,end;
//		end = System.currentTimeMillis();
//		System.out.println("use serial method call!" );
		
		start = System.currentTimeMillis();
		CompletableFuture<Double>futureTM = CompletableFuture.supplyAsync(()->priceOfTM());
		
		CompletableFuture<Double>futureTB = CompletableFuture.supplyAsync(()->priceOfJB());

		CompletableFuture<Double>futureJD = CompletableFuture.supplyAsync(()->priceOfJD());

	    CompletableFuture.allOf(futureTM,futureTB,futureJD).join();
	    
	    CompletableFuture.supplyAsync(()->priceOfTM()).thenApply(String::valueOf)
	    .thenApply(str->"price "+str).thenAccept(System.out::println);
	    end = System.currentTimeMillis();
	    System.out.println("use completable future! "+(end-start));
	    try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	
	
	
	}

	private static double priceOfTM() {
		delay();
		return 1.00;
	}
	
	
	
	private static double priceOfJB() {
		delay();
		return 2.00;
	}
	
	
	private static double priceOfJD() {
		delay();
		return 3.00;
	}
	
	
	
	private static void delay() {
		int time = new Random().nextInt(500);
		
		try {
			TimeUnit.MICROSECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("After %s sleep!\n", time);
	}

}

package com.msb.juc.c025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String>strs = new ConcurrentLinkedQueue<>();
		for(int i = 0; i <10; i++) {
			strs.offer("a "+i);
		}
		System.out.println(strs);
		System.out.println(strs.size());
		
		System.out.println(strs.poll());
		System.out.println(strs.size());

		
		System.out.println(strs.peek());
		System.out.println(strs.size());
	}

}

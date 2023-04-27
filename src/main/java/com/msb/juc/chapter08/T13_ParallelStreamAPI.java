package com.msb.juc.chapter08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T13_ParallelStreamAPI {

	public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i <10000; i++) {
        	nums.add(1000000+r.nextInt(1000000));
        
        }
        
        
        long start = System.currentTimeMillis();
        nums.forEach(v->isPrime(v));
        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();
        nums.parallelStream().forEach(T13_ParallelStreamAPI::isPrime);
        end = System.currentTimeMillis();
        System.out.println(end-start);
		
		
	}

	
	
	static boolean isPrime(int num) {
		for(int i =2; i <= num/2; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}

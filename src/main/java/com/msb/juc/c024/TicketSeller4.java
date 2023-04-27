package com.msb.juc.c024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class TicketSeller4 {
	static Queue<String>tickets = new ConcurrentLinkedQueue<>();
	
	static {
		for(int i = 0; i < 1000;i++) {
			tickets.add("票编号: "+i);
		}
	}

	public static void main(String[] args) {
           for(int i = 0; i< 10; i++) {
        	   new Thread(()->{
        		   while(true) {
                       String s = tickets.poll();
                       if(s==null) {
                    	   break;
                       }else {
                    	   System.out.println("销售了---"+s);
                       }
        	
        			   
        			   
        		   }
        		   
        	   }).start();
           }
	}

}

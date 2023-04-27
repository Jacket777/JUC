package com.msb.juc.c025;

import java.util.concurrent.LinkedTransferQueue;

public class T09_TransferQueue {

	public static void main(String[] args) {
        LinkedTransferQueue<String>strs = new LinkedTransferQueue<>();
		new Thread(()->{
			
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}).start();
		
		strs.put("aaa");
            
	}

}

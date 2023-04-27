package com.msb.juc.c022;

public class M {
	@Override
	protected void finalize()throws Throwable{
		System.out.println("finalize");
	}

}

package com.msb.juc.c018;

/**
 * 不能用string作为锁
 */
public class T {
    String s1 = "Hello";
    String s2 = "Hello";

    void m1(){
        synchronized (s1){

        }
    }

    void m2(){
        synchronized (s2){

        }
    }

}

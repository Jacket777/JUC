package com.thread.basic01.c37;

/**
 * 15-24 协作对象
 */
public class AssemblePoint {
    private int n;
    public AssemblePoint(int n){
        this.n = n;
    }

    public synchronized void await()throws InterruptedException{
        if(n >0){
            n--;
            if(n==0){
                notifyAll();
            }else{
                while(n!=0){
                    wait();
                }
            }
        }
    }
}

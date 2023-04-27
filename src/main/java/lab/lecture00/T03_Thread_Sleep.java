package lab.lecture00;

import java.util.Date;

public class T03_Thread_Sleep {

    private static class MyThread extends Thread{
        boolean flag = true; //停止线程

        @Override
        public void run() {
            while(flag){
                System.out.println("---------"+new Date()+"-------");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Thread be interrupted...");
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // t.interrupt();//打断线程，不建议使用
        t.flag = false; //正确使用


    }
}




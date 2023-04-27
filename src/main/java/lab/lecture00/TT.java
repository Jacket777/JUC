package lab.lecture00;

public class TT implements Runnable{
    int b = 100;

    public synchronized void m1()throws Exception{
        b =1000;
        Thread.sleep(5000);
        System.out.println("b = "+b);

    }


    public synchronized void m2()throws Exception{
        Thread.sleep(2500);
        b = 2000;
       // System.out.println(b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        TT tt = new TT();
        Thread t = new Thread(tt);
        t.start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            tt.m2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("b = "+tt.b);
    }
}

package lab.lecture00;

/**
 * 一个线程对象，启动两个线程
 */

public class T07_Thread03 {
    public static void main(String[] args) {
        Runner2 r = new  Runner2();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();


    }


    private static class Runner2 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println(Thread.currentThread().getName()+" No. "+i);

            }
        }
    }
}

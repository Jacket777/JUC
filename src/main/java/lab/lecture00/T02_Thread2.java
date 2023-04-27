package lab.lecture00;

import java.util.concurrent.TimeUnit;

public class T02_Thread2 {

    private static class Runner1 extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Runner1 :"+ i);

            }

        }
    }
    public static void main(String[] args) {
        Runner1 t = new Runner1();
       // Thread t = new Thread(r);
        t.start();
        //t.run();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main thread....."+i);
        }

    }
}




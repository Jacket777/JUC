package lab.lecture00;

public class T04_Thread_Join {

    private static class MyThread extends Thread{
        MyThread(String s){
            super(s);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("I am "+ getName());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public static void main(String[] args) {
        MyThread t = new MyThread("t1");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 10; i++) {
            System.out.println("I am main thread");
        }



    }
}




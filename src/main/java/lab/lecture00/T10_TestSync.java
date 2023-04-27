package lab.lecture00;

/**
 * 同步
 */
public class T10_TestSync implements Runnable {
    Timer timer = new Timer();

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());

    }

    private static class Timer{
        private static int num = 0;

        public synchronized void add(String name){
           // synchronized (this){
                num++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                System.out.println(name+" ,  你是第 "+num+"个使用timer的线程");
           // }

        }
    }


    public static void main(String[] args) {
        T10_TestSync test = new T10_TestSync();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();


    }
}

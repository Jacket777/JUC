package lab.lecture00;

/**
 * 优先级越高，得到执行时间越多
 */
public class T06_Thread_Priority {

    private static class T1 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("T1"+":"+i);

            }
        }
    }


    private static class T2 implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("---------T2"+":"+i);

            }
        }
    }




    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        //t1.setPriority(Thread.NORM_PRIORITY+3);
        t1.start();
        t2.start();

    }
}




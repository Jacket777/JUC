package lab.lecture00;

/**
 * 结束线程的正确方法
 */
public class T09_Thread05 {
    public static void main(String[] args) {
        Runner4 r = new Runner4();
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 100000; i++) {
            if( i % 1000 == 0 & i > 0){
                System.out.println("in thread main i = "+i);
            }
        }
        System.out.println("Thread main is over");
        r.shutDown();

    }

    private static class Runner4 implements Runnable{
        private boolean flag = true;

        @Override
        public void run() {
            int i = 0;
            while(flag){
                System.out.println(" "+i++);
            }
        }

        public void shutDown(){
            flag = false;
        }
    }
}

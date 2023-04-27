package lab.lecture00;

public class T08_Thread04 {
    public static void main(String[] args) {
        Runner3 r = new Runner3();
        Thread t = new Thread(r);
        t.start();

    }

    private static class Runner3 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                if(i%10 == 0 && i!=10){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("No. "+i);
                }

            }
        }
    }
}

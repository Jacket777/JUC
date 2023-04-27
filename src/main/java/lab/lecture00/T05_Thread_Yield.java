package lab.lecture00;

public class T05_Thread_Yield {

    private static class MyThread extends Thread{
        MyThread(String s){
            super(s);
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(getName()+":"+i);
                if(i%10 == 0){
                    yield();
                }
            }
        }
    }
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("tttttttt2");
        t1.start();
        t2.start();
    }
}




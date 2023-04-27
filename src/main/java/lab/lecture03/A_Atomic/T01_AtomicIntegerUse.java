package lab.lecture03.A_Atomic;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger的使用
 */
public class T01_AtomicIntegerUse {
    public AtomicInteger count = new AtomicInteger(0);

    public void add(){
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
    }


    public static void main(String[] args) {
        T01_AtomicIntegerUse t = new T01_AtomicIntegerUse();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(t::add,"thread"+i));
        }

        threadList.forEach((o)->o.start());

        threadList.forEach((o)-> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }





}





package lab.lecture03.D_CyclicBarrier;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 同步工具CyclicBarrier使用
 */
public class TestCyclicBarrier {


    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("20 send car");
            }
        });

        //定义方法--2
        CyclicBarrier barrier1 = new CyclicBarrier(20,()->{
            System.out.println("tttttt");
        });
        //定义方法--3
        CyclicBarrier barrier2 = new CyclicBarrier(20);

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }

    }
}

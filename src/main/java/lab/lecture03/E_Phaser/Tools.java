package lab.lecture03.E_Phaser;

import java.util.concurrent.TimeUnit;

public class Tools {
    public static void millisleep(int milli){
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

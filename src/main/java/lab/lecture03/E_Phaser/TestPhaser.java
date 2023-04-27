package lab.lecture03.E_Phaser;

import java.util.Random;

/**
 * Phaser的使用
 */
public class TestPhaser {

    public static MarriagePhaser phaser = new MarriagePhaser();

    public static void main(String[] args) {
        phaser.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Person("p"+i)).start();

        }
        new Thread(new Person("woman")).start();
        new Thread(new Person("man")).start();
    }

   public static class Person implements Runnable{
        public String name;

        public Person(String name){
            this.name = name;
        }

        public void arrive(){
            Tools.millisleep(new Random().nextInt(1000));
            System.out.printf("%s arrive! \n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void eat(){
            Tools.millisleep(new Random().nextInt(1000));
            System.out.printf("%s eat! \n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void leave(){
            Tools.millisleep(new Random().nextInt(1000));
            System.out.printf("%s eat! \n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void hug(){
            if(name.equals("man")||name.equals("woman")){
                Tools.millisleep(new Random().nextInt(1000));
                System.out.printf("%s room \n",name);
                phaser.arriveAndAwaitAdvance();
            }else{
                phaser.arriveAndDeregister();
            }
        }


        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();

        }
    }
}

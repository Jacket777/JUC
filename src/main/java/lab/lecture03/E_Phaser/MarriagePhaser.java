package lab.lecture03.E_Phaser;

import java.util.concurrent.Phaser;

public class MarriagePhaser extends Phaser {
    @Override
    protected boolean onAdvance(int phase,int registeredParties){
        switch (phase){
            case 0:
                System.out.println("all people arrive! "+registeredParties);
                System.out.println();
                return false;
            case 1:
                System.out.println("all people eat! "+ registeredParties);
                System.out.println();
                return false;
            case 2:
                System.out.println("all people leave! "+registeredParties);
                System.out.println();
                return false;
            case 3:
                System.out.println("man and woman hug"+registeredParties);
                return true;
            default:
                return true;

        }
    }


}

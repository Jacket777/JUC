package lab.lecture00;

public class ProducerConsumer {
    public static void main(String[] args) {

    }



}


class WoTou{
    int id;
    WoTou(int id){
        this.id = id;
    }
}


class SyncStack{
    int index = 0;
    WoTou[]arrWT = new WoTou[6];

    public void push(WoTou wt){
        arrWT[index] = wt;
        index++;
    }


    public WoTou pop(){
        index--;
        return arrWT[index];
    }
}
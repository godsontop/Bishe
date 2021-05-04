package StationStuff;

import java.util.ArrayList;

public class Train {
    String line;

    int direction;
//    0上1下
    int volume;

    ArrayList<Flow>  trainFlow;

    void loadFlow(ArrayList<Flow> flows){
//        将车站客流转入到列车
        for (int i =0;i<flows.size();i++){
            if(flows.get(i).getiKiTime()>1000*120){

            }
        }


    }
    void dropFlow() {

    }
}

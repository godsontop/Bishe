package Simulation;

import java.text.ParseException;

import static Operator.TrainOperator.revelArr;

public class test {
    public static void main(String[] args) throws ParseException {
//        Simulation sim = new Simulation();
//        for (int i = 0; i<180; i++) {
//            System.out.println(sim.getStartTime() +"  "+ sim.getEndTime());
//            sim.update(sim.getStartTime());
//        }
         int[] line1RouteUp = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int[] line1RouteDown = revelArr(line1RouteUp);
        System.out.println(line1RouteUp);
    }
}

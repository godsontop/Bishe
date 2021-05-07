package GraphAlg;

import StationStuff.Flow;
import Operator.FlowOperator;
import Operator.TrainOperator;

import java.util.ArrayList;

public class Test {
    public static void testPlanAndNextLeave() throws Exception {
        FlowOperator fo = new FlowOperator();
        ArrayList<Flow> a = new ArrayList<>();
        a.add(new Flow(5,1,13,44,0));
        a.add(new Flow(2,1,13,44,0));
        a.add(new Flow(3,1,33,55,0));
        a.add(new Flow(4,1,17,77,0));

        for(int i = 0 ;i<a.size();i++) {
            fo.planRoute(a.get(i));
            fo.nextLeaveIterator(a.get(i));
            System.out.println(a.get(i).getNextStop());
        }


    }

//    public static void main(String[] args) throws Exception {
//        TrainOperator to = new TrainOperator();
//        ArrayList<Flow> a = new ArrayList<>();
//        a.add(new Flow(5,1,13,44,0));
//        a.add(new Flow(2,1,23,44,0));
//        a.add(new Flow(3,1,33,55,0));
//        a.add(new Flow(4,1,17,77,0));
//        ArrayList<Flow> a1 = new ArrayList<>();
//        a1.add(a.get(0));
//        a.remove(0);
//        System.out.println(a1.get(0).getStartIndex()+","+a.get(0).getStartIndex());
//        testPlanAndNextLeave();
    public static void main(String[] args) {
        TrainOperator to = new TrainOperator();
        ArrayList<Flow> fl = new ArrayList<>();
//        a.add(new Flow(5,1,13,44,0));
//        a.add(new Flow(2,1,23,44,0));
//        a.add(new Flow(3,1,33,55,0));
//        a.add(new Flow(4,1,17,77,0));

    }




}

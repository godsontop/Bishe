package StationStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TrainOperator {
//    TODO:未测试
    public ArrayList<Train> getLine1() {
        return Line1;
    }

    public void setLine1(ArrayList<Train> line1) {
        Line1 = line1;
    }

    public ArrayList<Train> getLine101() {
        return Line101;
    }

    public void setLine101(ArrayList<Train> line101) {
        Line101 = line101;
    }

    public ArrayList<Train> getLine102() {
        return Line102;
    }

    public void setLine102(ArrayList<Train> line102) {
        Line102 = line102;
    }

    public ArrayList<Train> getLine2() {
        return Line2;
    }

    public void setLine2(ArrayList<Train> line2) {
        Line2 = line2;
    }

    public ArrayList<Train> getLine4() {
        return Line4;
    }

    public void setLine4(ArrayList<Train> line4) {
        Line4 = line4;
    }

    public static ArrayList<Integer> intToInteger(int[] intArray) {
        ArrayList<Integer> integerArray = (ArrayList<Integer>) Arrays.stream(intArray).boxed().collect(Collectors.toList());
        return integerArray;
    }
    public static int[] revelArr(int[] arr){
        for(int i=0;i<arr.length/2;i++){
            //两个数组元素互换
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        return arr;
    }

    private static int[] line1RouteUp = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    private static int[] line1RouteDown = revelArr(line1RouteUp);
    private static int[] line101RouteUp = {20,21,22,23,24,25,26,27};
    private static int[] line101RouteDown = revelArr(line101RouteUp);
    private static int[] line102RouteUp = {20,28,29,30,31,32,33};
    private static int[] line102RouteDown = revelArr(line102RouteUp);
    private static int[] line2RouteUp = {34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,10,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66};
    private static int[] line2RouteDown = revelArr(line2RouteUp);
    private static int[] line4RouteUp = {67,68,69,70,71,72,73,74,5,75,76,77,46,78,79,80,16};
    private static int[] line4RouteDown = revelArr(line4RouteUp);

    ArrayList<Train> Line1 = new ArrayList<>();
    ArrayList<Train> Line101 = new ArrayList<>();
    ArrayList<Train> Line102 = new ArrayList<>();
    ArrayList<Train> Line2 = new ArrayList<>();
    ArrayList<Train> Line4 = new ArrayList<>();

    public void trainGenerator(int flag,int dir){
        if(flag==1){
            if(dir == 1) {
                Line1.add(new Train("1号线上行", intToInteger(line1RouteUp), 0,20));
            } else {
                Line1.add(new Train("1号线下行", intToInteger(line1RouteDown), 0,0));
            }
        } else if(flag ==2){
            if(dir ==1) {
                Line2.add(new Train("2号线上行", intToInteger(line2RouteUp), 0,66));
            } else {
                Line2.add(new Train("2号线下行", intToInteger(line2RouteDown), 0,34));
            }
        } else if(flag ==4) {
            if(dir ==1) {
                Line4.add(new Train("4号线上行", intToInteger(line4RouteUp), 0,16));
            } else {
                Line4.add(new Train("4号线下行", intToInteger(line4RouteDown), 0,67));
            }
        } else if(flag ==101){
            if(dir ==1) {
                Line101.add(new Train("1号线支线1上行", intToInteger(line101RouteUp), 0,27));
            } else {
                Line2.add(new Train("1号线支线1下行", intToInteger(line101RouteDown), 0,20));
            }
        } else if(flag == 102){
            if(dir ==1) {
                Line102.add(new Train("1号线支线2上行", intToInteger(line102RouteUp), 0,33));
            } else {
                Line102.add(new Train("1号线支线2下行", intToInteger(line102RouteDown), 0,20));
            }
        } else {

            System.out.println("没有找到对应线路");
        }


    }

    public void analysNextStop(Train tr) {
        tr.setCurrentStop(tr.getTrainRoute().get(0));
        if(tr.getTrainRoute().size()<1){
//            TODO:终点站的处置感觉不妙，应检查
            tr.setNextStop(tr.getFinalStop());
        } else {
            tr.setNextStop(tr.getTrainRoute().get(1));
        }
    }

    public boolean isTrainAtStation(Train tr){
//        判断列车是否在车站
        if(tr.getCurrentTime()==0){
            return true;
        } else {
            return false;
        }
    }

    public boolean isAtFinalStop(Train tr) {
        if(tr.getNextStop()==tr.getFinalStop()) {
            return true;
        } else {
            return false;
        }
    }

    public void deletePast(Train tr){
        tr.getTrainRoute().remove(0);
    }
    public void atStation(ArrayList<Flow> stationFlow,ArrayList<Flow> trainFlow,Station s,Train tr) throws Exception {
//        在车站要完成的事：装载客流、释放客流、更新列车车站
//        TODO:想办法将到达终点站的车移出队列！
        tr.setCurrentTime(0);
        analysNextStop(tr);
        deletePast(tr);
        dropFlow(trainFlow,tr,s);
        loadFlow(stationFlow,tr);

    }

    void loadFlow(ArrayList<Flow> flows,Train tr) throws Exception {
//        将车站客流转入到列车
        FlowOperator fo = new FlowOperator();
        if(flows.size()==0) {
//            车站没有人就不加载
            return;
        }else {
            for (int i = 0; i < flows.size(); i++) {
                if (flows.get(i).getiKiTime() > 1000 * Flow.getInBoundTime()) {
                    if (flows.get(i).getNextStop() == tr.getNextStop()) {
                        flows.get(i).setLabel("运输中");
                        tr.getTrainFlow().add(flows.get(i));
                        flows.remove(i);
                    }
                }
            }
        }


    }

    void dropFlow(ArrayList<Flow> trainFlow,Train tr,Station s) throws Exception {
//        下车时已帮乘客找好了下一路线
        FlowOperator fo = new FlowOperator();
        if(trainFlow.size()==0) {
            return;
        }else {
            for (int i = 0; i < trainFlow.size(); i++) {
            if(trainFlow.get(i).getNextStop() == tr.getCurrentStop()){
                Flow flow = trainFlow.get(i);
                flow.setCurrentStation(tr.getCurrentStop());//更新这股流的到达站
                fo.nextLeaveIterator(flow); //更新这股流的下一站
                flow.setLabel(fo.convORLeave(flow));
                s.getFlowStack().add(flow);
                trainFlow.remove(i);

            }
            }
        }

    }

}

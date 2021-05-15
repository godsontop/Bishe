package Operator;

import Simulation.Simulation;
import StationStuff.Flow;
import StationStuff.Station;
import StationStuff.Train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

    private static final int[] line1RouteUp = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    private static final int[] line1RouteDown = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
    private static final int[] line101RouteUp = {20,21,22,23,24,25,26,27};
    private static final int[] line101RouteDown = {27,26,25,24,23,22,21,20};
    private static final int[] line102RouteUp = {20,28,29,30,31,32,33};
    private static final int[] line102RouteDown = {33,32,31,30,29,28,20};
    private static final int[] line2RouteUp = {34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,10,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66};
    private static final int[] line2RouteDown = {66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,10,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34};
    private static final int[] line4RouteUp = {67,68,69,70,71,72,73,74,5,75,76,77,46,78,79,80,16};
    private static final int[] line4RouteDown = {16,80,79,78,46,77,76,75,5,74,73,72,71,70,69,68,67};

    private static final String line1UpFirst = "2019-01-04 5:54:00";
    private static final String line1DownFirst = "2019-01-04 6:02:00";
    private static final String line2UpFirst = "2019-01-04 6:00:00";
    private static final String line2DownFirst = "2019-01-04 6:04:00";
    private static final String line4UpFirst = "2019-01-04 6:00:00";
    private static final String line4DownFirst = "2019-01-04 6:00:00";
    private static final String line101UpFirst = "2019-01-04 6:04:00";
    private static final String line101DownFirst = "2019-01-04 6:00:00";
    private static final String line102UpFirst = "2019-01-04 6:10:00";
    private static final String line102DownFirst = "2019-01-04 6:00:00";


    private static final int coldDown1Up = 270*1000;
    private static final int coldDown1Down = 270*1000;
    private static final int coldDown2Up = 350*1000;
    private static final int coldDown2Down = 350*1000;
    private static final int coldDown4Up = 350*1000;
    private static final int coldDown4Down = 350*1000;
    private static final int coldDown101Up = 540*1000;
    private static final int coldDown101Down = 540*1000;
    private static final int coldDown102Up = 540*1000;
    private static final int coldDown102Down = 540*1000;

    private int[] nextTrainTime = {0,0,0,0,0,0,0,0,0,0};

    public int[] getNextTrainTime() {
        return nextTrainTime;
    }

    public void setNextTrainTime(int[] nextTrainTime) {
        this.nextTrainTime = nextTrainTime;
    }

    ArrayList<Train> Line1 = new ArrayList<>();
    ArrayList<Train> Line101 = new ArrayList<>();
    ArrayList<Train> Line102 = new ArrayList<>();
    ArrayList<Train> Line2 = new ArrayList<>();
    ArrayList<Train> Line4 = new ArrayList<>();
//    public void initStartTrain(int flag,int dir ,int index, int timeStamp){
////        TODO:优化目标，从开始时刻模拟
//    }

    public boolean canStartGenerate(int flag,int dir,String time) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =  df.parse(time);

        if(dir ==1){
            if(flag ==1){
                Date date1 =df.parse(line1UpFirst);
                return date.getTime()>=date1.getTime();
            } else if(flag == 2){
                Date date1 =df.parse(line2UpFirst);
                return date.getTime()>=date1.getTime();
            } else if (flag ==3){
                Date date1 =df.parse(line4UpFirst);
                return date.getTime()>=date1.getTime();
            } else if (flag ==4){
                Date date1 =df.parse(line101UpFirst);
                return date.getTime()>=date1.getTime();
            } else if (flag ==5){
                Date date1 =df.parse(line102UpFirst);
                return date.getTime()>=date1.getTime();
            }
        } else {
            if(flag ==1){
                Date date1 =df.parse(line1DownFirst);
                return date.getTime()>=date1.getTime();
            } else if(flag == 2){
                Date date1 =df.parse(line2DownFirst);
                return date.getTime()>=date1.getTime();
            } else if (flag ==3){
                Date date1 =df.parse(line4DownFirst);
                return date.getTime()>=date1.getTime();
            } else if (flag ==4){
                Date date1 =df.parse(line101DownFirst);
                return date.getTime()>=date1.getTime();
            } else if (flag ==5){
                Date date1 =df.parse(line102DownFirst);
                return date.getTime()>=date1.getTime();
            }
        }
        return false;
    }
    public boolean canGenerate(int flag,int dir){
        if(dir ==1) {
            if(flag ==1){
                return nextTrainTime[0]<=0;
            }
            if(flag ==2){
                return nextTrainTime[2]<=0;
            }
            if(flag ==3){
                return nextTrainTime[4]<=0;
            }
            if(flag ==4){
                return nextTrainTime[6]<=0;
            }
            if(flag ==5){
                return nextTrainTime[8]<=0;
            }
        } else{
            if(flag ==1){
                return nextTrainTime[1]<=0;
            }
            if(flag ==2){
                return nextTrainTime[3]<=0;
            }
            if(flag ==3){
                return nextTrainTime[5]<=0;
            }
            if(flag ==4){
                return nextTrainTime[7]<=0;
            }
            if(flag ==5){
                return nextTrainTime[9]<=0;
            }
        }
        return false;

    }
    public void trainGenerate(int flag, int dir){
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
        } else if(flag ==3) {
            if(dir ==1) {
                Line4.add(new Train("4号线上行", intToInteger(line4RouteUp), 0,16));
            } else {
                Line4.add(new Train("4号线下行", intToInteger(line4RouteDown), 0,67));
            }
        } else if(flag ==4){
            if(dir ==1) {
                Line101.add(new Train("1号线支线1上行", intToInteger(line101RouteUp), 0,27));
            } else {
                Line101.add(new Train("1号线支线1下行", intToInteger(line101RouteDown), 0,20));
            }
        } else if(flag == 5){
            if(dir ==1) {
                Line102.add(new Train("1号线支线2上行", intToInteger(line102RouteUp), 0,33));
            } else {
                Line102.add(new Train("1号线支线2下行", intToInteger(line102RouteDown), 0,20));
            }
        } else {

            System.out.println("没有找到对应线路");
        }


    }
    public void applyColdDown(int flag,int dir){
        if(dir ==1) {
            if(flag ==1){
                nextTrainTime[0]=coldDown1Up;
            }
            if(flag ==2){
                nextTrainTime[2]=coldDown2Up;
            }
            if(flag ==3){
                nextTrainTime[4]=coldDown4Up;
            }
            if(flag ==4){
                nextTrainTime[6]=coldDown101Up;
            }
            if(flag ==5){
                nextTrainTime[8]=coldDown102Up;
            }
        } else{
            if(flag ==1){
                nextTrainTime[1]=coldDown1Down;
            }
            if(flag ==2){
                nextTrainTime[3]=coldDown2Down;
            }
            if(flag ==3){
                nextTrainTime[5]=coldDown4Down;
            }
            if(flag ==4){
                nextTrainTime[7]=coldDown101Down;
            }
            if(flag ==5){
                nextTrainTime[9]=coldDown102Down;
            }
        }
    }
    public void updateColdDown(int[] timeList){
        for (int i =0;i<timeList.length;i++){
            timeList[i]-= Simulation.getTimeStamp()*1000;
        }
    }
    public void trainGenerator(String time) throws ParseException {
//        flag:1：1号线,2:2,3:4:4:101:5:102
//        应该能在每个仿真过程，在符合产生条件的情况下，产生列车并加入到对应线路List中
        updateColdDown(nextTrainTime);
        for(int flag =1;flag<=5;flag++){
            for(int dir=0;dir<=1;dir++){
                if(canStartGenerate(flag,dir,time)){
                    if(canGenerate(flag,dir)){
                        trainGenerate(flag,dir);
                        applyColdDown(flag,dir);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TrainOperator to = new TrainOperator();
        to.trainGenerate(1,1);
        System.out.println(to.getLine1().get(0).getTrainRoute());;
    }

    public void analysNextStop(Train tr) {
//        分析下一站！！并modify路线数组！！
        tr.setCurrentStop(tr.getTrainRoute().get(0));
        if(tr.getTrainRoute().size()==1){
//            TODO:终点站的处置感觉不妙，应检查
            tr.setNextStop(tr.getFinalStop());
        } else {
            tr.setNextStop(tr.getTrainRoute().get(1));
            tr.getTrainRoute().remove(0);
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

    public void trainMove(Train tr,StationOperator so) {
//        首先更新区间客流，然后列车区间运行时间，当列车到站时归零时间
//        关于区间客流：先写入文件后再移除
        tr.setCurrentTime(tr.getCurrentTime() + 1000*Simulation.getTimeStamp());
        spaceDropFlowManager(tr,so);

    }

    private void spaceAddFlowManager(Train tr, StationOperator so){
//        TODO:等dropFlow完，再UpateTrainFlow，再执行此函数
        int indexUp = so.getIndexInArrayListFromStationIndex(tr.getNextStop(),so);
        int indexDown = so.getIndexInArrayListFromStationIndex(tr.getCurrentStop(),so);
        if (tr.getLine().contains("2号线") || tr.getLine().contains("4号线")) {
            if(so.hasExtendSpace(so.getStations().get(so.getIndexInArrayListFromStationIndex(tr.getCurrentStop(),so)))) {
                if (!tr.isAddedToSpace()) {
                    if (tr.getLine().contains("上行")) {
                        so.getStations().get(indexUp).getExtendSpace().addSpaceUpFlow(tr.getVolume());
                    } else {
                        so.getStations().get(indexDown).getExtendSpace().addSpaceDownFlow(tr.getVolume());
                    }
                    tr.setAddedToSpace(true);
                }
            } else{
                if (!tr.isAddedToSpace()) {
                    if (tr.getLine().contains("上行")) {
                        so.getStations().get(indexUp).getSpace().addSpaceUpFlow(tr.getVolume());
                    } else {
                        so.getStations().get(indexDown).getSpace().addSpaceDownFlow(tr.getVolume());
                    }
                    tr.setAddedToSpace(true);
                }
            }
        }else {
            if(!tr.isAddedToSpace()) {
                if (tr.getLine().contains("上行")) {
                    so.getStations().get(indexUp).getSpace().addSpaceUpFlow(tr.getVolume());
                } else {
                    so.getStations().get(indexDown).getSpace().addSpaceDownFlow(tr.getVolume());
                }
                tr.setAddedToSpace(true);
            }

        }
    }
    private static int currentOrNext(Train tr ){
        if(tr.getLine().contains("上行")){
            return tr.getNextStop();
        }
        return tr.getCurrentStop();
    }
    private void spaceDropFlowManager(Train tr, StationOperator so){
        int indexUp = so.getIndexInArrayListFromStationIndex(tr.getNextStop(),so);
        int indexDown = so.getIndexInArrayListFromStationIndex(tr.getCurrentStop(),so);
        if (tr.getLine().contains("2号线") || tr.getLine().contains("4号线")) {
            if(so.hasExtendSpace(so.getStations().get(so.getIndexInArrayListFromStationIndex(tr.getCurrentStop(),so)))){
                if (tr.getCurrentTime() >= so.getStations().get(so.getIndexInArrayListFromStationIndex(currentOrNext(tr), so)).getSpace().getSpaceTime()) {
                    tr.setCurrentTime(0);
                    if (tr.isAddedToSpace()) {
                        if (tr.getLine().contains("上行")) {
                            so.getStations().get(indexUp).getExtendSpace().dropSpaceUpFlow(tr.getVolume());
                        } else {
                            so.getStations().get(indexDown).getExtendSpace().dropSpaceDownFlow(tr.getVolume());
                        }
                        tr.setAddedToSpace(false);
                    }
                }
            } else {
                if (tr.getCurrentTime() >= so.getStations().get(so.getIndexInArrayListFromStationIndex(currentOrNext(tr), so)).getSpace().getSpaceTime()) {
                    tr.setCurrentTime(0);
                    if (tr.isAddedToSpace()) {
                        if (tr.getLine().contains("上行")) {
                            so.getStations().get(indexUp).getSpace().dropSpaceUpFlow(tr.getVolume());
                        } else {
                            so.getStations().get(indexDown).getSpace().dropSpaceDownFlow(tr.getVolume());
                        }
                        tr.setAddedToSpace(false);
                    }
                }
            }
        }else {
            if (tr.getCurrentTime() >= so.getStations().get(so.getIndexInArrayListFromStationIndex(currentOrNext(tr),so)).getSpace().getSpaceTime()) {
                tr.setCurrentTime(0);
                if (tr.isAddedToSpace()) {
                    if (tr.getLine().contains("上行")) {
                        so.getStations().get(indexUp).getSpace().dropSpaceUpFlow(tr.getVolume());
                    } else {
                        so.getStations().get(indexDown).getSpace().dropSpaceDownFlow(tr.getVolume());
                    }
                    tr.setAddedToSpace(false);
                }
            }

        }

    }

    public boolean isAtFinalStop(Train tr) {
        if(tr.getNextStop()==tr.getFinalStop()) {
            return true;
        } else {
            return false;
        }
    }

//    public void deletePast(Train tr){
//        tr.getTrainRoute().remove(0);
//    }
    public int calculateTrainVolume(Train tr){
        int vol =0;
        for (int i=0;i<tr.getTrainFlow().size();i++){
            vol+=tr.getTrainFlow().get(i).getVolume();
        }
        return vol;
    }

    public void atStation( TrainOperator to,StationOperator so) throws Exception {
//        在车站要完成的事：装载客流、释放客流、更新列车车站
//

        for (int i=0;i<to.getLine1().size();i++){
            Train tr = to.getLine1().get(i);
            int index = so.getIndexInArrayListFromStationIndex(tr.getNextStop(), so);
            if(isTrainAtStation(tr)) {
                if (isAtFinalStop(tr)) {
                    dropFlow(tr, so.getStations().get(index));
                    to.getLine1().remove(i);//将到达终点站的车移出队列！

                } else {
                    analysNextStop(tr);
                    dropFlow(tr, so.getStations().get(index));
                    loadFlow(so.getStations().get(index).getFlowStack(), tr);
                    tr.setVolume(to.calculateTrainVolume(tr));

                    to.spaceAddFlowManager(tr,so);

                }
            }
        }
        for (int i=0;i<to.getLine2().size();i++){
            Train tr = to.getLine2().get(i);
            int index = so.getIndexInArrayListFromStationIndex(tr.getNextStop(), so);
            if(isTrainAtStation(tr)) {
                if (isAtFinalStop(tr)) {
                    dropFlow(tr, so.getStations().get(index));
                    to.getLine2().remove(i);//将到达终点站的车移出队列！
                } else {
                    analysNextStop(tr);
                    dropFlow(tr, so.getStations().get(index));
                    loadFlow(so.getStations().get(index).getFlowStack(), tr);
                    tr.setVolume(to.calculateTrainVolume(tr));

                    to.spaceAddFlowManager(tr,so);

                }
            }
        }
        for (int i=0;i<to.getLine4().size();i++){
            Train tr = to.getLine4().get(i);
            int index = so.getIndexInArrayListFromStationIndex(tr.getNextStop(), so);
            if(isTrainAtStation(tr)) {
                if (isAtFinalStop(tr)) {
                    dropFlow(tr, so.getStations().get(index));
                    to.getLine4().remove(i);//将到达终点站的车移出队列！
                } else {
                    analysNextStop(tr);
                    dropFlow(tr, so.getStations().get(index));
                    loadFlow(so.getStations().get(index).getFlowStack(), tr);
                    tr.setVolume(to.calculateTrainVolume(tr));

                    to.spaceAddFlowManager(tr,so);

                }
            }
        }
        for (int i=0;i<to.getLine101().size();i++){
            Train tr = to.getLine101().get(i);
            int index = so.getIndexInArrayListFromStationIndex(tr.getNextStop(), so);
            if(isTrainAtStation(tr)) {
                if (isAtFinalStop(tr)) {
                    dropFlow(tr, so.getStations().get(index));
                    to.getLine101().remove(i);//将到达终点站的车移出队列！
                } else {
                    analysNextStop(tr);
                    dropFlow(tr, so.getStations().get(index));
                    loadFlow(so.getStations().get(index).getFlowStack(), tr);
                    tr.setVolume(to.calculateTrainVolume(tr));

                    to.spaceAddFlowManager(tr,so);

                }
            }
        }
        for (int i=0;i<to.getLine102().size();i++){
            Train tr = to.getLine102().get(i);
            int index = so.getIndexInArrayListFromStationIndex(tr.getNextStop(), so);
            if(isTrainAtStation(tr)) {
                if (isAtFinalStop(tr)) {
                    dropFlow(tr, so.getStations().get(index));
                    to.getLine102().remove(i);//将到达终点站的车移出队列！
                } else {
                    analysNextStop(tr);
                    dropFlow(tr, so.getStations().get(index));
                    loadFlow(so.getStations().get(index).getFlowStack(), tr);
                    tr.setVolume(to.calculateTrainVolume(tr));
                    to.spaceAddFlowManager(tr,so);

                }
            }
        }


    }

    void loadFlow(ArrayList<Flow> flows,Train tr)  {
//        将车站客流转入到列车
        FlowOperator fo = new FlowOperator();
        if (flows.size() == 0) {
//            车站没有人就不加载
            return;
        } else {
            for (int i = 0; i < flows.size(); i++) {
                if (flows.get(i).getLabel().contains("入站")) {
                    if (flows.get(i).getiKiTime() > 1000 * Flow.getInBoundTime()) {
                        if (flows.get(i).getNextStop() == tr.getNextStop()) {
                            flows.get(i).setLabel("运输中");
                            tr.getTrainFlow().add(flows.get(i));
                            flows.remove(i);
                        }
                    }
                } else if (flows.get(i).getLabel().contains("换乘")) {
                    if (flows.get(i).getiKiTime() > 1000 * Flow.getConvTime()) {
                        if (flows.get(i).getNextStop() == tr.getNextStop()) {
                            flows.get(i).setLabel("运输中");
                            tr.getTrainFlow().add(flows.get(i));
                            flows.remove(i);
                        }
                    }
                }
            }
        }
    }

    void dropFlow(Train tr,Station s) throws Exception {
//        下车时已帮乘客找好了下一路线
        FlowOperator fo = new FlowOperator();
        if(tr.getTrainFlow().size()==0) {
            return;
        }else {
            for (int i = 0; i < tr.getTrainFlow().size(); i++) {
            if(tr.getTrainFlow().get(i).getNextStop() == tr.getCurrentStop()){
                Flow flow = tr.getTrainFlow().get(i);
                flow.setCurrentStation(tr.getCurrentStop());//更新这股流的到达站
                fo.nextLeaveIterator(flow); //更新这股流的下一站
                flow.setLabel(fo.convORLeave(flow));
                flow.setiKiTime(0);
                flow.setIsPlanedRoute(0);
//                if(tr.getLine().contains("2号线") || tr.getLine().contains("4号线")){
//                    if(tr.getLine().contains("上行")){
//                        s.getExtendSpace().dropSpaceUpFlow(flow.getVolume());
//                    } else{
//                        s.getExtendSpace().dropSpaceDownFlow(flow.getVolume());
//                    }
//                } else {
//                    if(tr.getLine().contains("上行")){
//                        s.getSpace().dropSpaceUpFlow(flow.getVolume());
//                    } else{
//                        s.getSpace().dropSpaceDownFlow(flow.getVolume());
//                    }
//                }
                fo.findTrain(flow);
                s.getFlowStack().add(flow);
                tr.getTrainFlow().remove(i);

            }
            }
        }

    }


}

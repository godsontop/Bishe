package Operator;


import ReadSql.odGenerate;
import Simulation.Simulation;
import StationStuff.Flow;
import StationStuff.Station;
import cn.hutool.core.util.ArrayUtil;

import java.util.ArrayList;


public class StationOperator {
    private ArrayList<Station> stations = new ArrayList<>();
    private ArrayList<Flow> flows = new ArrayList<>();
    public ArrayList<Station> getStations() {
        return stations;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public ArrayList<Flow> getFlows() {
        return flows;
    }

    public void setFlows(ArrayList<Flow> flows) {
        this.flows = flows;
    }


    static void addNormalStation(ArrayList<Station> ar, int index ){
        odGenerate od = new odGenerate();
        Station s1 = new Station(index);
        s1.getSpace().setIndex(index);
        s1.getSpace().setSpaceTime(od.getSpaceTime(index-1,index));
//        当不存在该区间，区间时间是0 see:ctrl+b
        ar.add(s1);

    }
    public void initGeneralSpace(ArrayList<Station> ar){

        odGenerate od = new odGenerate();
//        for(int i =0 ;i<ar.size();i++) {
//            if (i==) {
//
//            } else {
//                ar.get(i).getSpace().setIndex(i);
//
//            }
//        }

    }

    public static void modifyStationSpace(ArrayList<Station> ar, int index, int spaceIndex){
        Station s = ar.get(index);
        s.getSpace().setIndex(spaceIndex);

    }

    public void initStation(){
        //        TODO:写的很烂，没有扩展性。有时间再改吧
        for(int i = 0;i<=80;i++) {
//            int[] specialStation = {51,5, 10, 15,46,28,52,75,78,0,34,67};
            int[] specialStation = {0,5,10,15,28,34,46,51,52,67,75,78};
            if(ArrayUtil.contains(specialStation,i)){
                continue;
            }
            addNormalStation(stations,i);

        }
        stations.add(initNullSpaceStation(0));
        stations.add(initNullSpaceStation(34));
        stations.add(initNullSpaceStation(67));
        stations.add(initSpecialStation(28,20));
        stations.add(initSpecialStation(52,10));
        stations.add(initSpecialStation(75,5));
        stations.add(initSpecialStation(78,46));

        stations.add(initConvStation(5,2,7410,2));
        stations.add(initConvStation(10,2,5010,2));
        stations.add(initConvStation(15,3,8010,2));
        stations.add(initConvStation(46,2,7710,2));


    }

    public Station initNullSpaceStation(int index){
        odGenerate od = new odGenerate();
        Station st = new Station(index);
        st.getSpace().setIndex(index);
        st.getSpace().setSpaceTime(0);
        return st;
    }

    public Station initSpecialStation(int index,int nextIndex){
//        本车站，相邻车站编号
        odGenerate od = new odGenerate();
        Station st = new Station(index);
        st.getSpace().setIndex(index);
        st.getSpace().setSpaceTime(od.getSpaceTime(index,nextIndex));
        return st;


    }

    public Station initConvStation(int index, int spaceTime1, int extendIndex, int spaceTime2){
        //        前两位数字 相邻站点号，1：第一个额外换乘方向 0：防止混淆
        Station conv = new Station(index);
        conv.getSpace().setIndex(index);
        conv.getSpace().setSpaceTime(spaceTime1);
        conv.getExtendSpace().setIndex(extendIndex);
        conv.getExtendSpace().setSpaceTime(spaceTime2);
        return conv;
    }

    public void addVolume(StationOperator so ,int startIndex,int endIndex,int volume,int dir) throws Exception {
//        需要参数：所有车站的列表，进站出战、客流数、方向
        FlowOperator fo = new FlowOperator();
        Station s = so.getStations().get(so.getIndexInArrayListFromStationIndex(startIndex,so));
        ArrayList<Flow> flow = s.getFlowStack();
        Flow fl = new Flow(volume,dir,startIndex,endIndex, Simulation.getTimeStamp()*1000);
        fl.setCurrentStation(startIndex);
        fo.planRoute(fl);
        fo.findTrain(fl);
        fl.setLabel("入站");
        flow.add(fl);
//        if(dir == 1){
//            s.setStationFlowUp(volume);
//        } else {
//            s.setStationFlowDown(volume);
//        }
    }

    public void stationFlowIterate(ArrayList<Station>st){
        FlowOperator fo = new FlowOperator();
        for(int i=0;i<st.size();i++){
            if(i==51){
                continue;
            }
            fo.FlowIterate(st.get(i).getFlowStack());
        }
    }

    public int queryVolume(ArrayList<Flow> flows,int dir   ){
        int vol  = 0;
        for (int i = 0;i<flows.size();i++) {
            if(flows.get(i).getDir() == dir) {
                vol+=flows.get(i).getVolume();
            }
        }
        return vol;
    }
//    public Boolean queryTime(ArrayList<Flow> flows,int time){
////        参数：流量数组、需要查询时间的阈值，超过了阈值返回true;
//
//    }
    public int getIndexInArrayListFromStationIndex(int stationIndex, StationOperator so){
    //        给定车站编号在数组中找到索引位置
        for( int i=0;i<so.getStations().size();i++){
            if(so.getStations().get(i).getIndex()==stationIndex){
                return i;
            }
        }
        return -1;
    }

    public boolean hasExtendSpace(Station s){
        if (s.getExtendSpace().getIndex()!=-1){
            return true;
        }
        return false;
    }

    public void loadToSpace(){
//        车站客流加载到区间
    }
//    public void dropVolume(ArrayList<Station> ar ,int index,int volume,int dir){
//        Station s = ar.get(index);
//        if(dir == 1){
//            s.setStationFlowUp(volume);
//        } else {
//            s.setStationFlowDown(volume);
//        }
//    }



}

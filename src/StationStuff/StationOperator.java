package StationStuff;


import ReadSql.odGenerate;

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
            int[] specialStation = {51,5, 10, 15,46,28,52,75,78};
            if(i == specialStation[0]){
                continue;
            }
            if(i == specialStation[1]){
                continue;
            }
            if(i == specialStation[2]){
                continue;
            }
            if(i == specialStation[3]){
                continue;
            }
            if(i == specialStation[4]){
                continue;
            }
            if(i == specialStation[5]){
                continue;
            }
            if(i == specialStation[6]){
                continue;
            }
            if(i == specialStation[7]){
                continue;
            }
            if(i == specialStation[8]){
                continue;
            }
            addNormalStation(stations,i);

        }
        stations.add(initSpecialStation(28,20));
        stations.add(initSpecialStation(52,10));
        stations.add(initSpecialStation(75,5));
        stations.add(initSpecialStation(78,46));

        stations.add(initConvStation(5,2,7410,2));
        stations.add(initConvStation(10,2,5010,2));
        stations.add(initConvStation(15,3,8010,2));
        stations.add(initConvStation(46,2,7710,2));


    }

    public Station initSpecialStation(int index,int nextIndex){
//        本车站，相邻车站编号
        odGenerate od = new odGenerate();
        Station st = new Station(index);
        st.getSpace().setIndex(index);
        st.getSpace().setSpaceTime(od.getSpaceTime(index,nextIndex));
        return st;


    }

    public ConvStation initConvStation(int index,int spaceTime1,int extendIndex,int spaceTime2){
        //        前两位数字 相邻站点号，1：第一个额外换乘方向 0：防止混淆
        ConvStation conv = new ConvStation(index);
        conv.getSpace().setIndex(index);
        conv.getSpace().setSpaceTime(spaceTime1);
        conv.getExtendSpace().setIndex(extendIndex);
        conv.getExtendSpace().setSpaceTime(spaceTime2);
        return conv;
    }

    public void addVolume(ArrayList<Station> ar ,int startIndex,int endIndex,int volume,int dir) throws Exception {
//        需要参数：所有车站的列表，进站出战、客流数、方向
        FlowOperator fo = new FlowOperator();
        Station s = ar.get(startIndex);
        ArrayList<Flow> flow = s.getFlowStack();
        Flow fl = new Flow(volume,dir,startIndex,endIndex,30*1000);
        fl.setCurrentStation(startIndex);
        fo.planRoute(fl);
        fl.setLabel("候车");
        flow.add(fl);
        s.setStationFlowUp(queryVolume(flow,1));
        s.setStationFlowDown(queryVolume(flow,0));


//        if(dir == 1){
//            s.setStationFlowUp(volume);
//        } else {
//            s.setStationFlowDown(volume);
//        }
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

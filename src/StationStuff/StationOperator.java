package StationStuff;


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


    static void addStation(ArrayList<Station> ar,int index , int spaceIndex){
        Station s1 = new Station(index,spaceIndex);

        ar.add(s1);

    }

    public static void modifyStationSpace(ArrayList<Station> ar, int index, int spaceIndex){
        Station s = ar.get(index);
        s.setSpaceIndex(spaceIndex);

    }

    public void initStation(){
        for(int i = 0;i<=80;i++) {
            int[] convStation = {5, 10, 46};
            if(i == convStation[0]){
                continue;
            }
            if(i == convStation[1]){
                continue;
            }
            if(i == convStation[2]){
                continue;
            }
            addStation(stations,i,i);

        }
        ConvStation conv1 = new ConvStation(5,5);
        conv1.setExtendSpace(7410);
//        前两位数字 相邻站点号，1：第一个额外换乘方向 0：防止混淆
        ConvStation conv2 = new ConvStation(10,10);
        conv2.setExtendSpace(5010);
        ConvStation conv3 = new ConvStation(46,46);
        conv3.setExtendSpace(7710);
    }

    public void addVolume(ArrayList<Station> ar ,int startIndex,int endIndex,int volume,int dir){
//        需要参数：所有车站的列表，进站出战、客流数、方向
        Station s = ar.get(startIndex);
        ArrayList<Flow> flow = s.getFlowStack();
        flow.add(new Flow(volume,dir,startIndex,endIndex,0));
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
    public void dropVolume(ArrayList<Station> ar ,int index,int volume,int dir){
        Station s = ar.get(index);
        if(dir == 1){
            s.setStationFlowUp(volume);
        } else {
            s.setStationFlowDown(volume);
        }
    }



}

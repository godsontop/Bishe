package Simulation;

import GraphAlg.PathFinder;
import ReadSql.odGenerate;
import Operator.FlowOperator;
import Operator.StationOperator;
import Operator.TrainOperator;

import java.text.ParseException;

public class Simulator {
    public static void main(String[] args) throws Exception {
        odGenerate od = new odGenerate();
        FlowOperator fo = new FlowOperator();
        StationOperator so = new StationOperator();//unique
        so.initStation();
        Simulation sim = new Simulation();//unique
        TrainOperator to = new TrainOperator(); //unique



        for (int i = 1; i <= 180; i++) {
            stationFlowUpdate(so);
            currentTrainMove(to,so);
            stationUpdate(so,od,sim,fo);
            trainUpdate(to,sim);
            trainFlowUpdate(to,so);
            sim.update(sim.getStartTime());


        }
    }
    protected static void stationUpdate(StationOperator so, odGenerate od,Simulation sim,FlowOperator fo) throws Exception {
//        能够：更新每个车站的乘客流、为乘客流规划线路
        for (int j = 0; j <= 80; j++) {
            if (j == 51) {
//                    51号站点不存在
                continue;
            }
            for (int k = 0; k <= 80; k++) {
                if (k == j) {
                    continue;
                }
                if (k == 51) {
                    continue;
                }
                PathFinder pf = new PathFinder();
                so.addVolume(so.getStations(), j, k, od.getOD(j, k,sim), fo.getDir(pf.getODPath(j, k)));
            }
            for(int x =0;x<so.getStations().get(j).getFlowStack().size();x++) {
                fo.planRoute(so.getStations().get(j).getFlowStack().get(x));
            }
//                给车站流规划线路
//                String s = so.getStations().get(j);
//                String s1 = String.valueOf(j);
//                System.out.println("在"+sim.getStartTime()+"到"+sim.getEndTime()+s1 + "号站的客流是" + s.getStationFlow());

        }

    }
    protected static void stationFlowUpdate(StationOperator so){
        so.stationFlowIterate(so.getStations());
    }
    protected static void currentTrainMove(TrainOperator to,StationOperator so){
        for(int i =0;i<to.getLine1().size();i++){
            to.trainMove(to.getLine1().get(i),so);
        }
        for(int i =0;i<to.getLine2().size();i++){
            to.trainMove(to.getLine2().get(i),so);
        }
        for(int i =0;i<to.getLine4().size();i++){
            to.trainMove(to.getLine4().get(i),so);
        }
        for(int i =0;i<to.getLine101().size();i++){
            to.trainMove(to.getLine101().get(i),so);
        }
        for(int i =0;i<to.getLine102().size();i++){
            to.trainMove(to.getLine102().get(i),so);
        }
    }
    protected static void trainUpdate(TrainOperator to,Simulation sim) throws ParseException {
        to.trainGenerator(sim.getStartTime());
    }
    protected static void trainFlowUpdate(TrainOperator to,StationOperator so) throws Exception {
//        能够：更新列车线路及列车属性、上、下客流
        to.atStation(to,so);

    }
    protected static void flowUpdate(){

    }


}

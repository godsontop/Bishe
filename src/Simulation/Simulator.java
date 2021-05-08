package Simulation;

import GraphAlg.PathFinder;
import ReadSql.odGenerate;
import Operator.FlowOperator;
import Operator.StationOperator;
import Operator.TrainOperator;
import StationStuff.Station;
import cn.hutool.core.io.file.FileWriter;

import java.io.File;
import java.text.ParseException;

public class Simulator {
    public static void main(String[] args) throws Exception {
        odGenerate od = new odGenerate();
        FlowOperator fo = new FlowOperator();
        StationOperator so = new StationOperator();//unique
        so.initStation();
        Simulation sim = new Simulation();//unique
        TrainOperator to = new TrainOperator(); //unique
        FileWriter stationFlowWriter= new FileWriter(new File("stationFlow.txt"));
        FileWriter stationUpFlowWriter =new FileWriter(new File("stationUpFlowWriter.txt"));
        FileWriter stationDownFlowWriter =new FileWriter(new File("stationDownFlowWriter.txt"));
        FileWriter spaceUpFlowWriter = new FileWriter(new File("spaceFlow.txt"));
        FileWriter spaceDownFlowWriter = new FileWriter(new File("spaceFlow.txt"));



        for (int i = 1; i <= 180; i++) {
            stationFlowUpdate(so);//增加车站客流的ikiTime
            currentTrainMove(to,so);
            statSpaceFlow(so,spaceUpFlowWriter,spaceDownFlowWriter);
            stationInbondUpdate(so,od,sim,fo);
            trainUpdate(to,sim);
            trainFlowUpdate(to,so,stationFlowWriter,stationUpFlowWriter,stationDownFlowWriter);
            sim.update(sim.getStartTime());


        }
    }
    protected static void stationInbondUpdate(StationOperator so, odGenerate od, Simulation sim, FlowOperator fo) throws Exception {
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
                so.addVolume(so, j, k, od.getOD(j, k,sim), fo.getDir(pf.getODPath(j, k)));
            }
            for(int x =0;x<so.getStations().get(so.getIndexInArrayListFromStationIndex(j,so)).getFlowStack().size();x++) {
                fo.planRoute(so.getStations().get(so.getIndexInArrayListFromStationIndex(j,so)).getFlowStack().get(x));
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
    protected static void statSpaceFlow(StationOperator so,FileWriter spaceUpFlowWriter ,FileWriter spaceDownFlowWriter){
        for (int i =0;i<so.getStations().size();i++){
            Station s =so.getStations().get(i);
            spaceUpFlowWriter.append(String.valueOf(s.getSpace().getSpaceUpFlow())+",");
            spaceDownFlowWriter.append(String.valueOf(s.getSpace().getSpaceDownFlow())+",");
            if(so.hasExtendSpace(so.getStations().get(i))){
                spaceUpFlowWriter.append(String.valueOf(s.getExtendSpace().getSpaceUpFlow())+",");
                spaceDownFlowWriter.append(String.valueOf(s.getExtendSpace().getSpaceDownFlow())+",");
            }
        }
    }
    protected static void trainUpdate(TrainOperator to,Simulation sim) throws ParseException {
        to.trainGenerator(sim.getStartTime());
    }
    protected static void trainFlowUpdate(TrainOperator to,StationOperator so,FileWriter stationFlowWriter,FileWriter stationUpFlowWriter,FileWriter stationDownFlowWriter) throws Exception {
//        能够：更新列车线路及列车属性、上、下客流
//        记录
        to.atStation(to,so);
        for (int i=0;i<so.getStations().size();i++){
            Station s = so.getStations().get(i);
            s.setStationFlowUp(so.queryVolume(s.getFlowStack(),1));
            s.setStationFlowDown(so.queryVolume(s.getFlowStack(),0));
            s.setStationFlow(s.getStationFlowUp()+ s.getStationFlowDown());
            stationFlowWriter.append(String.valueOf(s.getStationFlow()));
            stationFlowWriter.append(",");
            stationUpFlowWriter.append(String.valueOf(s.getStationFlowUp()));
            stationUpFlowWriter.append(",");
            stationDownFlowWriter.append(String.valueOf(s.getStationFlowDown()));
            stationDownFlowWriter.append(",");
        }

    }


}

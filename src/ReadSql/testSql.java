package ReadSql;

import GraphAlg.PathFinder;
import Simulation.Simulation;
import StationStuff.FlowOperator;
import StationStuff.Station;
import StationStuff.StationOperator;

public class testSql {

    public static void main(String[] args) throws Exception {
        odGenerate od = new odGenerate();
        FlowOperator fo = new FlowOperator();
        StationOperator so = new StationOperator();
        so.initStation();
        Simulation sim = new Simulation();



        for (int i = 1; i <= 180; i++) {
            for (int j = 0; j <= 80; j++) {
                if (j == 51) {
//                    51号站点特殊处理
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
                for(i =0;i<so.getStations().get(j).getFlowStack().size();i++)
                fo.planRoute(so.getStations().get(j).getFlowStack().get(i));
//                String s = so.getStations().get(j);
                String s1 = String.valueOf(j);
//                System.out.println("在"+sim.getStartTime()+"到"+sim.getEndTime()+s1 + "号站的客流是" + s.getStationFlow());

            }

            sim.update(sim.getStartTime());


        }
    }
}

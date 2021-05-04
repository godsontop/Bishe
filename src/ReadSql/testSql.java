package ReadSql;

import GraphAlg.Subway;
import StationStuff.FlowOperator;
import StationStuff.Route;
import StationStuff.Station;
import StationStuff.StationOperator;

import java.text.ParseException;
import java.util.ArrayList;

public class testSql {

    public static void main(String[] args) throws Exception {
        odGenerate od = new odGenerate();
        FlowOperator fo = new FlowOperator();
        StationOperator so = new StationOperator();
        so.initStation();


        od.setTimeStamp(60);
        for (int i = 1; i <= 180; i++) {
            for (int j = 0; j <= 80; j++) {
                if (j == 51) {
                    continue;
                }
                for (int k = 0; k <= 80; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (k == 51) {
                        continue;
                    }
                    Subway sb = new Subway();


                    so.addVolume(so.getStations(), j, k, od.getOD(j, k), fo.getDir(sb.getODPath(j, k)));

                }
                Station s = so.getStations().get(j);
                String s1 = String.valueOf(j);
                System.out.println(s1 + "号站的客流是" + s.getStationFlow());
            }

            od.update(od.getStartTime());


        }
    }
}

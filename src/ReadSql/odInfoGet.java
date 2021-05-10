package ReadSql;

import GraphAlg.PathFinder;
import Operator.StationOperator;
import Simulation.Simulation;
import cn.hutool.core.io.file.FileWriter;

import java.io.File;
import java.sql.Connection;
import java.text.ParseException;

public class odInfoGet {


    public static void main(String[] args) throws ParseException {
        StationOperator so = new StationOperator();//unique
        so.initStation();
        odGenerate od = new odGenerate();
        Simulation sim = new Simulation();
        SqlToJava stj1 = new SqlToJava();
//        SqlToJava stj2 = new SqlToJava();
//        SqlToJava stj3 = new SqlToJava();
//        SqlToJava stj4 = new SqlToJava();
//        SqlToJava stj5 = new SqlToJava();
//        SqlToJava stj6 = new SqlToJava();
        Connection con1 = stj1.getConnection();
//        Connection con2 = stj2.getConnection();
//        Connection con3 = stj3.getConnection();
//        Connection con4 = stj4.getConnection();
//        Connection con5 = stj5.getConnection();
//        Connection con6 = stj6.getConnection();
        FileWriter odInfoWriter = new FileWriter(new File("odInfoWriter.txt"));
        for (int i = 1; i < Simulation.getSimulateTimes(); i++) {
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
                    odInfoWriter.append(od.getOD(j, k, sim.getStartTime(),con1) + "\r\n");

                }
            }
            sim.update(sim.getStartTime());
        }
//        endConnection
    }
}

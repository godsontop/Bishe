package Util;

import ReadSql.odGenerate;
import Simulation.Simulation;
import cn.hutool.core.io.file.FileWriter;

import java.io.File;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ReadThread extends Thread {
    private Thread t;
    private Connection con;
    private StringBuffer outPut = new StringBuffer();
    odGenerate od = new odGenerate();
    private int paraTime;
    private static int simTime = 10;
    private String time ;
    private Date date;
    FileWriter fw;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    ReadThread(Connection con,int paraTime,String time,FileWriter fw) throws ParseException {

        date = df.parse(time);
        date.setTime(date.getTime() + (paraTime * 1000));
        this.con = con;
        this.time = df.format(date);
        this.fw = fw;
        System.out.println("Creating ");
    }

    public void run() {
        for (int i = 1; i < simTime; i++) {
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
                    try {
                        outPut.append(od.getOD(j, k, time,con) + "\r\n");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
            date.setTime(date.getTime()+Simulation.getTimeStamp()*1000);
            time = df.format(date);
        }
        fw.write(String.valueOf(outPut));
    }


    public void start () {
        System.out.println("Starting ");
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }
}
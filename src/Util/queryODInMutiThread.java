package Util;

import Operator.StationOperator;
import ReadSql.SqlToJava;
import ReadSql.odGenerate;
import Simulation.Simulation;
import cn.hutool.core.io.file.FileWriter;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class queryODInMutiThread {
    public void mutiQuery(String time){

    }
    public static void main(String[] args) throws ParseException {
        StationOperator so = new StationOperator();//unique
        String time = "2019-01-04 10:00:00";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(time);
        so.initStation();
        odGenerate od = new odGenerate();
        Simulation sim = new Simulation();
        SqlToJava stj1 = new SqlToJava();
        SqlToJava stj2 = new SqlToJava();
        SqlToJava stj3 = new SqlToJava();
        SqlToJava stj4 = new SqlToJava();
        SqlToJava stj5 = new SqlToJava();
        SqlToJava stj6 = new SqlToJava();
//        SqlToJava stj7 = new SqlToJava();
//        SqlToJava stj8 = new SqlToJava();
//        SqlToJava stj9 = new SqlToJava();
//        SqlToJava stj10 = new SqlToJava();
        Connection con1 = stj1.getConnection();
        Connection con2 = stj2.getConnection();
        Connection con3 = stj3.getConnection();
        Connection con4 = stj4.getConnection();
        Connection con5 = stj5.getConnection();
        Connection con6 = stj6.getConnection();
//        Connection con7 = stj7.getConnection();
//        Connection con8 = stj8.getConnection();
//        Connection con9 = stj9.getConnection();
//        Connection con10 = stj10.getConnection();
        FileWriter fw1 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\a"));
        FileWriter fw2 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\b"));
        FileWriter fw3 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\c"));
        FileWriter fw4 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\d"));
        FileWriter fw5 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\e"));
        FileWriter fw6 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\f"));
//        FileWriter fw7 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\g"));
//        FileWriter fw8 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\h"));
//        FileWriter fw9 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\i"));
//        FileWriter fw10 = new FileWriter(new File("D:\\IdeaProjects\\Bishe\\data\\odDataTemp\\j"));
        ReadThread r1 = new ReadThread(con1,0,time,fw1);
        ReadThread r2 = new ReadThread(con2,10,time,fw2);
        ReadThread r3 = new ReadThread(con3,20,time,fw3);
        ReadThread r4 = new ReadThread(con4,30,time,fw4);
        ReadThread r5 = new ReadThread(con5,40,time,fw5);
        ReadThread r6 = new ReadThread(con6,50,time,fw6);
//        ReadThread r7 = new ReadThread(con7,36,time,fw6);
//        ReadThread r8 = new ReadThread(con8,42,time,fw6);
//        ReadThread r9 = new ReadThread(con9,48,time,fw6);
//        ReadThread r10 = new ReadThread(con10,54,time,fw6);
        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
        r6.start();
        r6.start();
//        r7.start();
//        r8.start();
//        r9.start();
//        r10.start();
        for(int i =1;i<100;i++) {
            System.out.println(".");
        }
        if(!r1.isAlive()&&!r2.isAlive()&&!r3.isAlive()&&!r4.isAlive()&&!r5.isAlive()&&!r6.isAlive())
                try {
                    FileCombine.combine("D:\\IdeaProjects\\Bishe\\data\\odDataTemp","D:\\IdeaProjects\\Bishe\\data\\odData\\"+time);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

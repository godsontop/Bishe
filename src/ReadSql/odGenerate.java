package ReadSql;
import Simulation.Simulation;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//TODO：update根据迭代方案修改

public class odGenerate {
    public odGenerate()  {
    }
    int getSpaceTime(int index1, int index2){
//        获得区间时间，从数据库查找，index1，2必须在图上是相邻的
        int a;
        int b;
        if(index1>index2){
            a = index2;
            b = index1;
        } else {
            a = index1;
            b = index2;
        }
//        select time from spaceTime where stationa = '51' and stationb = '52'
        String s1 = "\'"+String.valueOf(a)+"\'";
        String s2 = "\'"+String.valueOf(b)+"\'";
//        System.out.println(s1+s2);
        SqlToJava stj = new SqlToJava();
        try {
            Connection con = stj.getConnection();
//            System.out.println("开始读取数据");
            Statement cmd = con.createStatement();
            ResultSet rs = cmd.executeQuery("select time from spaceTime where stationa ="+s1+" and stationb ="+s2);
            rs.next();
            int res = rs.getInt(1);
//            // 关闭连接
//            cmd.close();//关闭命令对象连接
//            con.close();//关闭数据库连接
//            System.out.println(res);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return 12;
//        err 12:SQL exception
    }

    int getOD(int O, int D, Simulation sim) {
        String s1 = "\'"+String.valueOf(O)+"\'";
        String s2 = "\'"+String.valueOf(D)+"\'";
//        System.out.println(s1+s2);
        SqlToJava stj = new SqlToJava();
        try {
            Connection con = stj.getConnection();
//            System.out.println("开始读取数据");
            Statement cmd = con.createStatement();
            ResultSet rs = cmd.executeQuery("select count(*) " +
                    "from record201901040610 a join record201901040610 b " +
                    "on a.userID=b.userID " +
                    "where a.status='1' and b.status='0'and b.time>a.time and DATEDIFF(minute,a.time,b.time)<100" +
                    "and a.stationID="+s1+" and b.stationID="+s2+
                    "and a.time between "+"\'"+sim.getStartTime()+"\'"+" and"+"\'"+sim.getEndTime()+"\'");
            rs.next();
            int res = rs.getInt(1);
//            System.out.println(res);
//            // 关闭连接
//            cmd.close();//关闭命令对象连接
//            con.close();//关闭数据库连接
//            System.out.println(res);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return 12;
//        err 12:SQL exception


    }


    public static void main(String[] args) throws ParseException {
        odGenerate od = new odGenerate();
        System.out.println(od.getSpaceTime(50,10));
//        test
//        odGenerate od = new odGenerate();
////        for (int i =1;i<=3;i++) {
////            System.out.println(od.getEndTime(od.startTime));
////            od.update(od.startTime);
////
////
////        }
//        od.update(od.startTime);
//
//        System.out.println(od.analysEndTime(od.startTime));


    }

//    private int timeStamp = 60;
//    private String startTime = "2019-01-04 06:00:00";
////    private String endTime = "2019-01-04 07:00:00";
//    private String endTime = analysEndTime(startTime);
//
//    public int getTimeStamp() {
//        return timeStamp;
//    }
//
//    public void setTimeStamp(int timeStamp) {
//        this.timeStamp = timeStamp;
//    }
//
//    public String getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(String startTime) {
//        this.startTime = startTime;
//    }
//
//    public String getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(String startTime) throws ParseException {
//        this.endTime = analysEndTime(startTime);
//        //
//    }
//
//    public static String analysEndTime(String start) throws ParseException {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date =  df.parse(start);
//        date.setTime(date.getTime() + 1000*60*60);
////        System.out.println("endTime      ："+df.format(date));
//
//        return df.format(date);
//    }
//    public String update(String time) throws ParseException {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date =  df.parse(time);
//        date.setTime(date.getTime() + 1000*timeStamp);
////        System.out.println("当前时间      ："+df.format(date));
//        this.startTime = df.format(date);
//        return df.format(date);
//    }



}


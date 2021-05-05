package Simulation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
//    仿真模块，应该能完成：提供当前时间和结束时间、每个循环update()
    private  int timeStamp = 60;
    private String startTime = "2019-01-04 06:00:00";
    //    private String endTime = "2019-01-04 07:00:00";
    private String endTime = analysEndTime(startTime);

    public Simulation() throws ParseException {
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }



    public String analysEndTime(String start) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =  df.parse(start);
        date.setTime(date.getTime() + 1000*timeStamp);

//        System.out.println("endTime      ："+df.format(date));

        return df.format(date);
    }
    public Boolean update(String time) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =  df.parse(time);
        date.setTime(date.getTime() + 1000*timeStamp);
//        System.out.println("当前时间      ："+df.format(date));
        this.startTime = df.format(date);
        this.endTime = analysEndTime(startTime);
        return true;
    }


}

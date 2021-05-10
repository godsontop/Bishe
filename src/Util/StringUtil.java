package Util;

import cn.hutool.core.util.StrUtil;

public class StringUtil {
    public static int hourPlus(int hour){
        if(hour==24){
            return 0;
        } else if(hour ==25){
            return  1;
        } else if(hour ==26){
            return 2;
        }
        return hour;
    }
    public static String predictEndDate(int date,int startTime,int endTime){
        if(startTime>endTime){
            return String.format("%02d",date+1);
        }
     return String.format("%02d",date);
    }
    public static String sqlFormString(String s){
        return "\'"+s+"\'";
    }
    public static void main(String[] args) {
        String s = "2019-01-04 06:00:00";
        System.out.println(StrUtil.sub(s,11,13));
        System.out.println(StrUtil.sub(s,8,10));
        System.out.println(String.format("%02d",8));
    }
}

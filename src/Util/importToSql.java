package Util;

import ReadSql.SqlToJava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class importToSql {
    public static void createTable(Connection con) {
        try {
//            System.out.println("开始读取数据");


            for(int i=6;i<=22;i++){
                String csvDir ="D:\\课设\\Metro_train\\20190104\\metro"+String.format("%02d",i)+String.format("%02d",i+1)+".csv";
                Statement cmd = con.createStatement();
                cmd.executeQuery("CREATE TABLE metro"+String.format("%02d",i)+String.format("%02d",i+1)+"(" +
                        "time NVARCHAR(MAX)," +
                        "lineID NVARCHAR(MAX)," +
                        "stationID NVARCHAR(MAX)," +
                        "deviceID  NVARCHAR(MAX)," +
                        "status NVARCHAR(MAX)," +
                        "userID NVARCHAR(MAX)," +
                        "payType NVARCHAR(MAX)" +
                        ") " +
                        "BULK INSERT metro"+String.format("%02d",i)+String.format("%02d",i+1) +" "+
                        "FROM "+"\'" + csvDir +"\' "+
                        "WITH(" +
                        "FIELDTERMINATOR = ','," +
                        "ROWTERMINATOR = '\\n'" +
                        ") " +
                        "Delete From metro"+String.format("%02d",i)+String.format("%02d",i+1)+" where time ='time'"+
                        "SELECT * FROM metro0607");
//                rs.next();
//                int res = rs.getInt(1);
//            System.out.println(res);
//            // 关闭连接
                cmd.close();//关闭命令对象连接

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SqlToJava stj = new SqlToJava();
        Connection con = stj.getConnection();
        createTable(con);
        stj.endConnection(con);
    }
}

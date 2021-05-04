package ReadSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlToJava {
    private String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//设置SQL Server数据库引擎
    private String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=master";//指定数据库


    public Connection getConnection() {
        try {
            Class.forName(JDriver);//加载数据库引擎
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

        try {
            String user = "sa";
            String password = "111111";//登陆密码
            Connection con = DriverManager.getConnection(connectDB, user, password);//连接数据库
//            System.out.println("连接数据库成功");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;

    }


    public void endConnection(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


}

package ReadSql;

public class testSql {

    public static void main(String[] args) {
        int i =6;
        String csvDir ="D:\\课设\\Metro_train\\20190104\\metro"+String.format("%02d",i)+String.format("%02d",i+1)+".csv";
        String regexp = "CREATE TABLE metro"+String.format("%02d",i)+String.format("%02d",i+1)+"(" +
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
                "Delete From metro"+String.format("%02d",i)+String.format("%02d",i+1)+" where time ='time'";
        System.out.println(regexp);
    }

}

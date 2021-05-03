package ReadSql;

import java.text.ParseException;

public class testSql {
    public static void main(String[] args) throws ParseException {
        odGenerate od = new odGenerate();
        od.setTimeStamp(60);
        for (int i =1;i<=180;i++) {

            for (int j = 0;j<=80;j++){
                for (int k = 0;k<=80;k++){
                    if(j==k){
                        continue;
                    }
                    od.getOD(i,j);
                }
            }

            od.update(od.getStartTime());



        }
    }
}

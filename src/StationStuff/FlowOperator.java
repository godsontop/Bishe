package StationStuff;

import java.util.ArrayList;

public class FlowOperator {
    //    对每个时间间隔的客流进行操作
//    TODO:可能存在BUG，如线路编号特殊，应手动修改
    public int getDir(ArrayList<String > od){
        int a =Integer.parseInt(od.get(0));
        int b =Integer.parseInt(od.get(1));
        if(a > b){
            return 0;
        } else if(a==74&&b==5) {
            return 1;
        } else if(a==50&&b==10) {
            return 1;
        } else if(a==77&&b==46) {
            return 1;
        } else if(a==80&&b==16) {
            return 1;
        } else {
            return 1;
        }
    }
    public void planRoute(){

    }

}

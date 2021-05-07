package Operator;

import GraphAlg.PathFinder;
import Simulation.Simulation;
import StationStuff.Flow;
import StationStuff.Station;

import java.util.ArrayList;
import java.util.Iterator;

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
    public void planRoute(Flow fl) throws Exception {
//        按照地铁线路分段规划乘客路径,换乘站以中间站表示


            PathFinder pf = new PathFinder();
            ArrayList<String> route = pf.getODPath(fl.getStartIndex(), fl.getEndIndex());
            for (int i = 0; i < route.size(); i++) {
                if (route.get(i).contains("号线")) {
                    fl.getMidIndex().add(Integer.valueOf(route.get(i-1)));
                }
            }

    }

    public int findTrain(Flow fl) throws Exception {
        PathFinder pf = new PathFinder();

        int nextStation = Integer.parseInt(pf.getODPath(fl.getStartIndex(), fl.getEndIndex()).get(1));

        return nextStation;

    }
    public void FlowIterate(ArrayList<Flow> flows){
            for(int j=0;j<flows.size();j++) {
                flows.get(j).setiKiTime(flows.get(j).getiKiTime()+ Simulation.getTimeStamp());
            }
        }
    public void nextLeaveIterator(Flow fl) throws Exception {
//        找到下车（or换乘站）
//        TODO:remove方面放到另一个函数防止条件判断时被错误调用
        PathFinder pf = new PathFinder();
            if (fl.getMidIndex().size() == 0) {
                fl.setNextStop(fl.getEndIndex());
            } else {
                fl.setNextStop(fl.getMidIndex().get(0));
                fl.getMidIndex().remove(0);
            }
        }

//    public void modifyNextLeave(Flow fl) {
//
//    }

    public String convORLeave(Flow fl) throws Exception {
        PathFinder pf = new PathFinder();
        String s ;
        if(fl.getCurrentStation()==fl.getEndIndex()){
            s ="出站";
        } else {
            s = "换乘";
        }
        return s;
    }

    public  void outBoundManager(ArrayList<Flow> flows) {
        if(flows.size() == 0) {
            return;
        } else {
            for (int i=0;i<flows.size();i++) {
                if (flows.get(i).getiKiTime()>Flow.getOutBoundTime()*1000) {
                    flows.remove(i);
                }
            }
        }
    }

}

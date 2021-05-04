package StationStuff;

import java.util.ArrayList;

public class Station {
    private int index;

    private int stationFlowUp ;
//左or上 1
    private int stationFlowDown;

    public int getStationFlow() {

        return stationFlowUp+stationFlowDown;
    }

    public void setStationFlow(int stationFlow) {
        this.stationFlow = stationFlow;
    }

    //右or下 0
    private int stationFlow =stationFlowDown+stationFlowUp;

    private int spaceIndex;

    private Space space;

    private ArrayList<Flow> FlowStack = new ArrayList<>();

    public ArrayList<Flow> getFlowStack() {
        return FlowStack;
    }

    public void setFlowStack(ArrayList<Flow> flowStack) {
        FlowStack = flowStack;
    }

    public Station(int index, int spaceIndex){
        this.index = index;
        this.spaceIndex = index;

    }

    public int getIndex() {
        return index;
    }

    public int getStationFlowUp() {
        return stationFlowUp;
    }

    public int getStationFlowDown() {
        return stationFlowDown;
    }

    public int getSpaceIndex() {
        return spaceIndex;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setStationFlowUp(int stationFlowUp) {
        this.stationFlowUp = stationFlowUp;
    }

    public void setStationFlowDown(int stationFlowDown) {
        this.stationFlowDown = stationFlowDown;
    }

    public void setSpaceIndex(int spaceIndex) {
        this.spaceIndex = spaceIndex;
    }
    //    左or上区间






}

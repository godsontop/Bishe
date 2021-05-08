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
    private int stationFlow ;

    private Space space = new Space();

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    private Space extendSpace = new Space();



    public Space getExtendSpace() {
        return extendSpace;
    }

    public void setExtendSpace(Space extendSpace) {
        this.extendSpace = extendSpace;
    }

    private ArrayList<Flow> FlowStack = new ArrayList<>();

    public ArrayList<Flow> getFlowStack() {
        return FlowStack;
    }

    public void setFlowStack(ArrayList<Flow> flowStack) {
        FlowStack = flowStack;
    }

    public Station(int index){
        this.index = index;

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


    public void setIndex(int index) {
        this.index = index;
    }

    public void setStationFlowUp(int stationFlowUp) {
        this.stationFlowUp = stationFlowUp;
    }

    public void setStationFlowDown(int stationFlowDown) {
        this.stationFlowDown = stationFlowDown;
    }

    //    左or上区间






}

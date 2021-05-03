package StationStuff;

public class Station {
    private int index;

    private int stationFlowUp;

    private int stationFlowDown;

    private int spaceIndex;

    private Space space;
//    左or上

    Station(int index, int spaceIndex){
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

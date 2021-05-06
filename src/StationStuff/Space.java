package StationStuff;

public class Space {
//    区间，应能够实现：计数区间上下行客流
    int index;

    int upFlow;
//    向左or上的客流
    int downFlow;

    void loadUp() {

    }
    void loadDown() {

    }
    int spaceTime;

    int spaceFlow;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSpaceTime() {
        return spaceTime;
    }

    public void setSpaceTime(int spaceTime) {
        this.spaceTime = spaceTime;
    }

    public int getSpaceFlow() {
        return spaceFlow;
    }

    public void setSpaceFlow(int spaceFlow) {
        this.spaceFlow = spaceFlow;
    }
}

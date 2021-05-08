package StationStuff;

public class Space {
//    区间，应能够实现：计数区间上下行客流
    private int index=-1;

    private int upFlow;
//    向左or上的客流
    private int downFlow;

    private int spaceTime;

    private int spaceFlow;

    private int spaceUpFlow=0;
    private int spaceDownFlow=0;

    public int getSpaceUpFlow() {
        return spaceUpFlow;
    }

    public void setSpaceUpFlow(int spaceUpFlow) {
        this.spaceUpFlow = spaceUpFlow;
    }

    public int getSpaceDownFlow() {
        return spaceDownFlow;
    }

    public void setSpaceDownFlow(int spaceDownFlow) {
        this.spaceDownFlow = spaceDownFlow;
    }

    public void addSpaceUpFlow(int volume){
        this.spaceUpFlow+=volume;
    }
    public void addSpaceDownFlow(int volume){
        this.spaceDownFlow+=volume;
    }
    public void dropSpaceUpFlow(int volume){
        this.spaceUpFlow-=volume;
    }
    public void dropSpaceDownFlow(int volume){
        this.spaceDownFlow-=volume;
    }

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

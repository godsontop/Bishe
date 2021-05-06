package StationStuff;

public class ConvStation extends Station {
//高级版的车站 5近江 46钱江路 10凤起路
    private Space extendSpace = new Space();
    ConvStation(int index){
        super(index);
    }

    public Space getExtendSpace() {
        return extendSpace;
    }

    public void setExtendSpace(Space extendSpace) {
        this.extendSpace = extendSpace;
    }

    public void getOff(){

    }
}

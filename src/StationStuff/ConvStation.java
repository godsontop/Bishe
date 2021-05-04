package StationStuff;

public class ConvStation extends Station {
//高级版的车站 5近江 46钱江路 10凤起路
    private int extendSpace;
    ConvStation(int index, int spaceIndex){

        super(index,spaceIndex);
    }
    public void setExtendSpace(int extendSpace){
        this.extendSpace = extendSpace;

    }

    public void getOff(){

    }
}

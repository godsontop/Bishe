package StationStuff;

import java.util.ArrayList;

public class Flow {
    public Flow(int volume, int dir, int startIndex, int endIndex, int iKiTime) {
        this.volume = volume;
        this.dir = dir;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.iKiTime = iKiTime;
    }

    private int volume;
    private int dir;
    private int startIndex;
    private int endIndex;
    private int iKiTime;
    private int currentStation;
    private int nextStop;
    private String label;
    private static int inBoundTime = 120;
    private static int outBoundTime = 120;

    public static int getInBoundTime() {
        return inBoundTime;
    }

    public static void setInBoundTime(int inBoundTime) {
        Flow.inBoundTime = inBoundTime;
    }

    public static int getOutBoundTime() {
        return outBoundTime;
    }

    public static void setOutBoundTime(int outBoundTime) {
        Flow.outBoundTime = outBoundTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getNextStop() {
        return nextStop;
    }

    public void setNextStop(int nextStop) {
        this.nextStop = nextStop;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        this.currentStation = currentStation;
    }

    private ArrayList<Integer> midIndex = new ArrayList<>();

    public ArrayList<Integer> getMidIndex() {
        return midIndex;
    }

    public void setMidIndex(ArrayList<Integer> midIndex) {
        this.midIndex = midIndex;
    }
//    中间站

    public int getiKiTime() {
        return iKiTime;
    }

    public void setiKiTime(int iKiTime) {
        this.iKiTime = iKiTime;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

}

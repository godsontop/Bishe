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

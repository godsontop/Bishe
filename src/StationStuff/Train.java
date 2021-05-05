package StationStuff;

import java.util.ArrayList;

public class Train {

    String line;
    int nextStop;
    int finalStop;
    int currentStop;

    public int getCurrentStop() {
        return currentStop;
    }

    public void setCurrentStop(int currentStop) {
        this.currentStop = currentStop;
    }

    //    1上0下
    int volume;
    int currentTime;
//    当前站间运行时间
    int supposeTime;
//    预计站间运行时间



    public Train(String line,ArrayList<Integer> trainRoute, int currentTime ,int finalStop) {
        this.line = line;
        this.currentTime = currentTime;
        this.trainRoute = trainRoute;
        this.finalStop = finalStop;
    }


    ArrayList<Flow>  trainFlow = new ArrayList<>();
    ArrayList<Integer> trainRoute = new ArrayList<>();

    public ArrayList<Integer> getTrainRoute() {
        return trainRoute;
    }

    public void setTrainRoute(ArrayList<Integer> trainRoute) {
        this.trainRoute = trainRoute;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getNextStop() {
        return nextStop;
    }

    public void setNextStop(int nextStop) {
        this.nextStop = nextStop;
    }

    public int getFinalStop() {
        return finalStop;
    }

    public void setFinalStop(int finalStop) {
        this.finalStop = finalStop;
    }



    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public int getSupposeTime() {
        return supposeTime;
    }

    public void setSupposeTime(int supposeTime) {
        this.supposeTime = supposeTime;
    }

    public ArrayList<Flow> getTrainFlow() {
        return trainFlow;
    }

    public void setTrainFlow(ArrayList<Flow> trainFlow) {
        this.trainFlow = trainFlow;
    }
}

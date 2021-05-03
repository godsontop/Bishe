package GraphAlg;

public class Node {
    int stationId;
    String stationName;
    int pre=-1;
    int isVisted=0;
    Node(String stationName, int stationId){
        this.stationName=stationName;
        this.stationId=stationId;
    }
    public String toString(){
        return stationName;
    }
    public boolean equals(Object obj) {
        Node node =(Node) obj;
        return (this.stationId == node.stationId && this.stationName.equals(node.stationName));
    }
}


package GraphAlg;

public class Edge {
    Node start;
    Node end;
    Edge(Node start, Node end){
        this.start=start;
        this.end=end;
    }
    public boolean equals(Object obj) {
        Edge edge=(Edge) obj;
        return (this.start.equals(edge.start) && this.end.equals(edge.end));
    }
    public int hashCode() {
        int hash=start.stationId;
        hash=hash*131+end.stationId;
        return hash;
    }
}

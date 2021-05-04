package GraphAlg;

import java.io.*;
import java.util.*;

public class Subway {
    private String routePath="D:\\IdeaProjects\\Bishe\\data.txt";
     Map<String, Node> map=new HashMap<>();		//站点名到站点的映射
     Map<Edge,String> eLine=new HashMap<>();			//边到所属线路的映射
    public  Graph loadMap(String filePath) {
//        System.out.println("loading map from "+filePath);
        List<Node> vertices = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        BufferedReader bufferedReader=null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8"));
            String lineTxt;
            int stationId=0;			//给读入的站点按顺序编号
            while((lineTxt = bufferedReader.readLine())!=null) {
                String[] strs = lineTxt.split(" ");			//分离出各站点名
                for(int i=1;i<strs.length;i++) {
                    if(map.containsKey(strs[i])); 			//将不重复站点名创建节点
                    else {
                        Node s=new Node(strs[i],stationId++);
                        vertices.add(s);
                        map.put(strs[i], s);
                    }
                }
            }
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8"));
            while((lineTxt = bufferedReader.readLine())!=null) {
                String[] strs = lineTxt.split(" ");
                for(int i=1;i<strs.length-1;i++) {
                    Edge e=new Edge(map.get(strs[i]),map.get(strs[i+1]));
                    edges.add(e);
                    eLine.put(e, strs[0]);
                    e=new Edge(map.get(strs[i+1]),map.get(strs[i]));
                    edges.add(e);
                    eLine.put(e, strs[0]);
                }
            }
            bufferedReader.close();
        }catch(Exception e) {
            System.out.println("failed to read map");
            System.exit(0);
        }
//        System.out.println("load map successfully!");
        return new Graph(vertices,edges);
    }
    public  List<Node> getShortestPath(String start, String end, Graph graph) throws Exception {
        List<Node> list=new ArrayList<>();
        try {
            if(!map.containsKey(start)) {
                throw new Exception("There is no such an start station!!!");

            }
            if(!map.containsKey(end)) {
                throw new Exception("There is no such an end station!!!");
            }
            if(start.equals(end)) {
                throw new Exception("You are at your target place!!!");
            }
        }catch(Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        int pre=0,in=1;
        Node Start=map.get(start);
        Node End=map.get(end);
        List<Node> oper=new ArrayList<>();
        oper.add(Start);
        Start.isVisted=1;
        List<List<Edge>> edges=graph.edges;
        while(pre!=in) {
            List<Edge> vedges=edges.get(oper.get(pre++).stationId);
            int flag=0;
            for(int i=0;i<vedges.size();i++) {
                if(vedges.get(i).end.isVisted==1) {
                    continue;
                }
                Node now=vedges.get(i).end;
                now.isVisted=1;
                now.pre=pre-1;
                oper.add(now);
                in++;
                if(now.equals(End)) {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                break;
        }
        if(pre==in)
            return null;
        else {
            in--;
            Stack<Node> stack=new Stack<>();
            Node tmp;
            while((tmp=oper.get(in)).pre!=-1) {
                stack.push(tmp);
                in=tmp.pre;
            }
            stack.push(Start);
            while(!stack.isEmpty())
                list.add(stack.pop());

        }
        return list;
    }

    public ArrayList<String> getODPath(int ori, int des) throws Exception {
//        给起点O,终点D,找到最短路径
//        TODO:格式化路线图
        ArrayList<String> OD = new ArrayList<>();
        String s1 = String.valueOf(ori);
        String s2 = String.valueOf(des);
        Graph graph = loadMap(routePath);
        List<Node> shortest = getShortestPath(s1, s2, graph);
        if(shortest.size()==2){
//            System.out.print(shortest.get(0)+","+shortest.get(1));
            OD.add(String.valueOf(shortest.get(0)));
            OD.add(String.valueOf(shortest.get(1)));
        } else {
//            System.out.print(shortest.get(0));
            OD.add(String.valueOf(shortest.get(0)));
            String preLine, inLine;
            preLine = eLine.get(new Edge(shortest.get(0), shortest.get(1)));
            inLine = eLine.get(new Edge(shortest.get(1), shortest.get(2)));

//            System.out.print("->" + shortest.get(1));

            OD.add(String.valueOf(shortest.get(1)));

            if (!preLine.equals(inLine)) {
//                System.out.printf("\n换乘地铁" + inLine + "\n");
                OD.add(inLine);
            }


//            System.out.print("->" + shortest.get(2));

            OD.add(String.valueOf(shortest.get(2)));
            for (int i = 3; i < shortest.size(); i++) {
                preLine = inLine;
                inLine = eLine.get(new Edge(shortest.get(i - 1), shortest.get(i)));
                if (!preLine.equals(inLine)) {
//                    System.out.printf("\n换乘地铁" + inLine + "\n");
                    OD.add(inLine);
                }
//                System.out.print("->" + shortest.get(i));
                OD.add(String.valueOf(shortest.get(i)));
            }
        }
        return OD;
    }

    public static void main(String[] args) throws Exception {
//        test


//        od = sb.getODPath(0,2);
//
//        for (int i = 0; i < od.size(); i++) {
//            System.out.println(od.get(i));
//        }
        for(int j =1;j<80;j++) {
            if (j == 51){
                continue;
            }
            Subway sb = new Subway();
//            Subway sb1 = new Subway();
            ArrayList<String > od;
            od = sb.getODPath(0, j);
//            od1 =sb1.getODPath(0,2);

            for (int i = 0; i < od.size(); i++) {
                System.out.println(od.get(i));
            }
        }
//    }

//    public static void main(String args[]) throws Exception {
////        Scanner input=new Scanner(System.in);
////        System.out.println("请输入地图存放路径 和 起点终点 (如：C:\\Users\\XX\\Desktop\\地铁线路信息.txt 天通苑 雍和宫)");
//        String filePath="D:\\IdeaProjects\\Bishe\\data.txt";
//        String start="54";
//        String end="3";
//
//        Graph graph=loadMap(filePath);
//        List<Station> shortest= getShortestPath(start,end,graph);
//        System.out.print(shortest.get(0));
//        String preLine,inLine;
//        preLine=eLine.get(new Edge(shortest.get(0),shortest.get(1)));
//        inLine=eLine.get(new Edge(shortest.get(1),shortest.get(2)));
//        System.out.print("->"+shortest.get(1));
//        if(!preLine.equals(inLine))
//            System.out.printf("\n换乘地铁"+inLine+"\n");
//        System.out.print("->"+shortest.get(2));
//        for(int i=3;i<shortest.size();i++) {
//            preLine=inLine;
//            inLine=eLine.get(new Edge(shortest.get(i-1),shortest.get(i)));
//            if(!preLine.equals(inLine))
//                System.out.printf("\n换乘地铁"+inLine+"\n");
//            System.out.print("->"+shortest.get(i));
        }
   }



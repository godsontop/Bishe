package Util;

import GraphAlg.PathFinder;

import java.io.*;

public class FileReaderTest {
    static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("odInfoWriter.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void read(ReadSelectedLine rsl) throws IOException {

//            if (j == 51) {
////                    51号站点不存在
//                continue;
//            }
//            for (int k = 0; k <= 80; k++) {
//                if (k == j) {
//                    continue;5555
//                }
//                if (k == 51) {
//                    continue;
//                }
//                PathFinder pf = new PathFinder();
//                so.addVolume(so, j, k, od.getOD(j, k,sim), fo.getDir(pf.getODPath(j, k)));
            System.out.println(rsl.readLineVarFile(reader));

//                so.addVolume(so, j, k, ReadSelectedLine.readLineVarFile(reader), fo.getDir(pf.getODPath(j, k)));

    }

    public static void main(String[] args) throws IOException {
        ReadSelectedLine rsl = new ReadSelectedLine();
        for (int i = 0; i < 5; i++) {
            read(rsl);
        }
    }
}

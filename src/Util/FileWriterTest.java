package Util;

import StationStuff.Station;
import cn.hutool.core.io.file.FileWriter;

import java.io.File;

public class FileWriterTest {
    static FileWriter stationUpFlowWriter =new FileWriter(new File("stationUpFlowWriter11.txt"));

    public static void main(String[] args) {
        for (int i =0;i<15;i++){
            stationUpFlowWriter.append(i+"\n");

        }
    }

}

package Output;


import cn.hutool.core.io.file.FileWriter;

import java.io.File;

public class outPut {
    public static void main(String[] args) {
        FileWriter fw= new FileWriter(new File("stationFlow.txt"));
        fw.append("1");
        fw.append(",");
        fw.append("2");
        fw.append("\r\n");
        fw.append("3");
    }
}

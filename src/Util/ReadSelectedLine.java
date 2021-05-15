package Util;

import java.io.*;

public class ReadSelectedLine {

//    public static int readLineVarFile(String fileName, int lineNumber) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                new FileInputStream(fileName)));
//        String line = reader.readLine();
//        if (lineNumber < 0 || lineNumber > getTotalLines(fileName)) {
//            System.out.println("不在文件的行数范围之内。");
//        }
//        int num = 0;
//        while (line != null) {
//            if (lineNumber == ++num) {
//                return Integer.parseInt(line);
//            }
//            line = reader.readLine();
//        }
//        reader.close();
//    }
    public int readLineVarFile(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return Integer.parseInt(line);
    }
    public static String readLineStringVarFile(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return line;
    }


    // 文件内容的总行数。
    static int getTotalLines(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName)));
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream("data.txt")));
        for (int i=0;i<4;i++){
            System.out.println(readLineStringVarFile(reader));
        }
    }
}

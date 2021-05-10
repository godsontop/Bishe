package Util;

import java.io.*;

public class FileCombine {
    public static  void  combine(String FileInPath,String FileOut) throws IOException {
        //定义输出目录
        BufferedWriter bw=new BufferedWriter(new FileWriter(FileOut));
        //读取目录下的每个文件或者文件夹，并读取文件的内容写到目标文字中去
        File[] list = new File(FileInPath).listFiles();
        int fileCount = 0;
        int folderConut= 0;
        for(File file : list)
        {
            if(file.isFile())
            {
                fileCount++;
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while((line=br.readLine())!=null) {
                    bw.write(line);
                    bw.newLine();
                }
                br.close();
            }else {
                folderConut++;
            }
        }
        bw.close();
        System.out.println("输入目录下文件个数为"+fileCount);
        System.out.println("输入目录下文件夹个数为"+folderConut);

    }

    public static void main(String[] args) throws IOException {
        combine("D:\\课设\\Metro_train\\test","1.csv");
    }

}

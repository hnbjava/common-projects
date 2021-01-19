package com.hnb.demo.biz.io;

import java.io.*;

/**
 * @author xiaolu
 * @date 2018/8/29 上午9:35
 */
public class ReadFile {
    public static void main(String[] args) {
        try {
            File outfile = new File("C:\\Users\\hnbcao\\Desktop\\output\\alldata2");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outfile));

            for (int i = 10700; i < 10751; i++) {
                File file = new File("C:\\Users\\hnbcao\\Desktop\\output\\data-" + i);
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String data = reader.readLine();
                while (data != null) {
                    data= data.replace("][","]rickdata[");
                    String[] list = data.split("rickdata");
                    for (String s : list) {
                        writer.write(s);
                        writer.newLine();
                    }
                    data = reader.readLine();
                }
                reader.close();
            }
            writer.close();
        } catch (IOException e) {

        }

    }
}

package com.hnb.demo.biz.io;

import java.io.*;

/**
 * @author xiaolu
 * @date 2018/8/29 上午9:35
 */
public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/xiaolu/Documents/GitHub/hannibal/bizdemo/src/main/resources/text.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String data = reader.readLine();
            while (data != null) {
                System.out.println(data);
                data = reader.readLine();
            }
        } catch (IOException e) {

        }

    }
}

package com.hnb.demo.biz.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author xiaolu
 * @date 2018/8/16 上午9:06
 */
public class Marketing {
    private static final String DEMOGRAPHIC = "blahblah.txt";

    public static void main(String[] args) throws Exception {
        int reps = 10;
        if (args.length > 0) {
            reps = Integer.parseInt(args[0]);
        }

        FileOutputStream fos = new FileOutputStream(DEMOGRAPHIC);
        GatheringByteChannel gatheringChannel = fos.getChannel();

        ByteBuffer[] bs = utterBS(reps);

        while (gatheringChannel.write(bs) > 0) {

        }
        System.out.println("SSSSSS" + DEMOGRAPHIC);
        fos.close();
    }

    private static String[] col1 = {
            "111", "112", "113", "114"
    };

    private static String[] col2 = {
            "121", "122", "123", "124"
    };

    private static String[] col3 = {
            "131", "132", "133", "134"
    };

    private static String newLine = System.getProperty("line.separator");

    private static ByteBuffer[] utterBS(int howMany) throws UnsupportedEncodingException {
        List list = new LinkedList();
        for (int i = 0; i < howMany; i++) {
            list.add(pickRandom(col1, " "));
            list.add(pickRandom(col2, " "));
            list.add(pickRandom(col3, newLine));
        }
        ByteBuffer[] bufs = new ByteBuffer[list.size()];
        list.toArray(bufs);
        return bufs;
    }

    private static Random rand = new Random();

    private static ByteBuffer pickRandom(String[] strings, String suffix) throws UnsupportedEncodingException {
        int index = rand.nextInt(strings.length);
        String indexStr = index + "XX";
        String string = strings[index];
        int total = string.length() + suffix.length() + indexStr.length();
        ByteBuffer buf = ByteBuffer.allocate(total);
        buf.put(indexStr.getBytes("US-ASCII"));
        buf.put(string.getBytes("US-ASCII"));
        buf.put(suffix.getBytes("US-ASCII"));
        buf.flip();
        return buf;
    }
}

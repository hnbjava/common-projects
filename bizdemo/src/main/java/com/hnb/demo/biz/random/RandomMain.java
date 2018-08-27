package com.hnb.demo.biz.random;

import java.util.Random;

/**
 * @author xiaolu
 * @date 2018/8/24 上午11:05
 */
public class RandomMain {
    //生成随机数字和字母,
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();
        //length为几位密码
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(3) == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(3) == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
    public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(3));
        }
        System.out.println(getStringRandom(6));
    }
}

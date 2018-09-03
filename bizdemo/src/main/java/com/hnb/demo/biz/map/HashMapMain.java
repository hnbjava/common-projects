package com.hnb.demo.biz.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaolu
 * @date 2018/8/31 上午9:54
 */
public class HashMapMain<K,V> extends HashMap<K,V> {


    public static void main(String[] args) {
        Map map = new HashMapMain<String, String>();
        for (int i = 0; i < 100; i++) {
            map.put("key" + i, i);
        }
        System.out.println(map.get("key12"));
    }

}

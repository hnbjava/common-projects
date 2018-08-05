package com.hnb.demo.biz.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author xiaolu
 * @date 2018/8/2 上午10:14
 */
public class HashMapAndHashTable {
    static Hashtable<Integer, Integer> table = new Hashtable<>();
//    static HashMap<Integer, Integer> table = new HashMap<>();

    //分别在两个子线程内对hashtable进行put,get操作
    public static void main(String[] args) {

        new Thread(() -> {
            // TODO Auto-generated method stub
            System.out.println("线程1执行");
            for (int i = 0; i < 1000; i++) {
                table.put(i,i);
            }
            System.out.println("线程1---------" + table.get(500));
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("线程2执行");
                for (int i = 1000; i < 2000; i++) {
                    table.put(i, i);
                }
                System.out.println("线程2---------" + table.get(1500));
            }
        }).start();
    }
}

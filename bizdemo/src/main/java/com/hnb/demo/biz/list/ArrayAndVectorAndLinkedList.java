package com.hnb.demo.biz.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author xiaolu
 * @date 2018/8/2 下午2:36
 */
public class ArrayAndVectorAndLinkedList {


    public static void main(String[] args) {
        List arrayList = new ArrayList();
        List vector = new Vector();
        List linkedList = new LinkedList();

        synchronized (linkedList) {
            for (int i = 0; i < 10000000; i++) {
                if (i % 500 == 0) {
                    try {
                        System.out.println("vector.wait();");
                        linkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        synchronized (linkedList) {
            for (int i = 0; i < 10000000; i++) {
                if (i % 500 - 20 == 0) {
                    System.out.println("vector.notify();");
                    linkedList.notify();
                }
            }

        }

    }
}

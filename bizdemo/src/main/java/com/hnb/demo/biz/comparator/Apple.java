package com.hnb.demo.biz.comparator;

import java.util.Comparator;

/**
 * @author xiaolu
 * @date 2018/7/31 下午4:43
 */
public class Apple implements Comparator {

    private int size;

    public Apple(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Apple && o2 instanceof Apple){
            if (((Apple) o1).size > ((Apple) o2).size){
                return -1;
            }
        }
        return 1;
    }
}

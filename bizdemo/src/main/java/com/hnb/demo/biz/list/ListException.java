package com.hnb.demo.biz.list;

import java.util.ArrayList;
import java.util.List;

public class ListException {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10 ; i++) {
            list.add(i);
        }

        for (Integer integer:list) {
            list.remove(integer);
        }
    }
}

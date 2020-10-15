package com.hnb.demo.biz.kafka;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.*;

/**
 * Copyright (C), 2019-2020, 中冶赛迪重庆信息技术有限公司
 * <p>
 * ClassName： TableDataCreator
 * <p>
 * Description：
 *
 * @author hnbcao
 * @version 1.0.0
 * @date 2020/10/15 上午11:04
 */

public class TableDataCreator {
    private static Calendar calendar = Calendar.getInstance();

    private static List<TableData> createList(String tableName) {
        List<TableData> dataList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            long receiveTime = calendar.getTimeInMillis();
//            calendar.setTime(new Date(receiveTime + 1000));
            TableData record = new TableData();
            Map<String, Serializable> values = new HashMap<>();
            values.put("device_code", "Q1000100010031000-S001" + i);
            values.put("receive_time", receiveTime);
            values.put("create_date", String.valueOf(receiveTime));
            values.put("data01", i);
            values.put("data02", i);
            record.setTableName(tableName);
            record.setValues(values);
            dataList.add(record);
        }
        return dataList;
    }

    public static String createListString(int id) {
        StringJoiner joiner = new StringJoiner("");
        joiner.add("test_table");
        if (id < 10) {
            joiner.add("0");
        }
        joiner.add(String.valueOf(id));
        return JSON.toJSONString(createList(joiner.toString()));
    }

    public static void main(String[] args) {
        System.out.println(createListString(1));
        System.out.println(createListString(11));
    }
}

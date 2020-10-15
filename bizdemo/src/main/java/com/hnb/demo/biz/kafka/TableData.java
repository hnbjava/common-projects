package com.hnb.demo.biz.kafka;


import java.io.Serializable;
import java.util.Map;

/**
 * Copyright (C), 2019-2020, 中冶赛迪重庆信息技术有限公司
 * <p>
 * ClassName： TableData
 * <p>
 * Description：
 *
 * @author hnbcao
 * @version 1.0.0
 * @date 2020/10/15 上午11:02
 */

public class TableData {
    private String tableName;
    private Map<String, Serializable> values;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, Serializable> getValues() {
        return values;
    }

    public void setValues(Map<String, Serializable> values) {
        this.values = values;
    }
}

package com.hnbcao.demo.easyexcel;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;
import lombok.Data;

/**
 * Copyright (C), 2019-2021, 中冶赛迪重庆信息技术有限公司
 * <p>
 * ClassName： DemoData
 * <p>
 * Description：
 *
 * @author hnbcao
 * @version 1.0.0
 * @date 2021/1/14 下午3:50
 */

@Data
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;

    @ExcelProperty("日期标题")
    private Date date;

    @ExcelProperty("数字标题")
    private Double doubleData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
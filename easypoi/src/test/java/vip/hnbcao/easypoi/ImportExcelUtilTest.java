package vip.hnbcao.easypoi;


import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ImportExcelUtilTest {

    @Test
    public void importExcel() throws Exception {
        List<Map> data = ImportExcelUtil.importExcel("/data/Work/主数据/元数据批量导入模板.xlsx");
        System.out.println(data);
    }

    @Test
    public void importMainData() throws Exception {
        ImportExcelUtil.importMainData("/data/Work/主数据/主数据导入、导出模板.xlsx");
    }
}
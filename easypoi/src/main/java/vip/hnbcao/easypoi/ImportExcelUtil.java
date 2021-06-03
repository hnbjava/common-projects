package vip.hnbcao.easypoi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.*;

public class ImportExcelUtil {
    public static List<Map> importExcel(String filePath) throws Exception {
        File excel = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(excel);

//        InputStream fileInputStream = new FileInputStream("/data/Work/主数据/元数据批量导入模板.xlsx");
        Workbook wb = WorkbookFactory.create(fileInputStream);
//        wb.getNumberOfSheets();
        wb.sheetIterator().forEachRemaining(sheet -> {
            int rowNum = sheet.getPhysicalNumberOfRows();
            int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
            for (int j = 0; j < rowNum; j++) {
                Row row = sheet.getRow(j);
                for (short k = 0; k < cellNum; k++) {
                    Cell cell = row.getCell(k);
                    if (cell != null) {
                        if (cell.getCellTypeEnum() == CellType.STRING) {
                            System.out.print(cell.getStringCellValue());
                        } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                            System.out.print(cell.getNumericCellValue());
                        } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                            System.out.print(cell.getBooleanCellValue());
                        } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                            System.out.print("NULL");
                        } else {
                            System.out.print(cell.getDateCellValue());
                        }
                    } else {
                        System.out.print("error");
                    }
                    System.out.print(" | ");
                }
                System.out.println("-----------------------------");
            }

        });


        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1);
        importParams.setHeadRows(10);
//        importParams.setReadRows(4);

        List<Map> data = ExcelImportUtil.importExcel(fileInputStream, Map.class, importParams);
        return data;
    }

    public static void importMainData(String filePath) throws Exception {
        File excel = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(excel);

//        InputStream fileInputStream = new FileInputStream("/data/Work/主数据/元数据批量导入模板.xlsx");
        Workbook wb = WorkbookFactory.create(fileInputStream);
        Sheet dataSheet = wb.getSheetAt(0);
        List<Map> data = reduceMainData(dataSheet);
//        wb.getNumberOfSheets();
        wb.sheetIterator().forEachRemaining(sheet -> {


        });
    }

    private static List<Map> reduceMainData(Sheet dataSheet) {
        int cellNum = dataSheet.getRow(0).getPhysicalNumberOfCells();
        List<String> header = resolveDataHeader(dataSheet,cellNum);
        System.out.println(header);
        List<Map> data = resolveDataValue(dataSheet,header,cellNum);
        return data;
    }

    private static List<Map> resolveDataValue(Sheet dataSheet, List<String> header, int cellNum) {
        List<Map<String, Serializable>> data =  Collections.emptyList();
        int rowNum = dataSheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowNum; i++) {
            Row row = dataSheet.getRow(0);
            for (short k = 0; k < cellNum; k++) {
                Cell cell = row.getCell(k);
                if (cell != null) {
                    if (cell.getCellTypeEnum() == CellType.STRING) {
                        data.add(cell.getStringCellValue());
                    } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                        data.add(String.valueOf(cell.getNumericCellValue()));
                    } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                        data.add(String.valueOf(cell.getBooleanCellValue()));
                    } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                        return header;
                    } else {
                        data.add(String.valueOf(cell.getDateCellValue()));
                    }
                }
            }
        }
        return null;
    }

    private static List<String> resolveDataHeader(Sheet dataSheet, int cellNum) {
        List<String> header = new ArrayList<>();

        Row row = dataSheet.getRow(0);
        for (short k = 0; k < cellNum; k++) {
            Cell cell = row.getCell(k);
            if (cell != null) {
                if (cell.getCellTypeEnum() == CellType.STRING) {
                    header.add(cell.getStringCellValue());
                } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                    header.add(String.valueOf(cell.getNumericCellValue()));
                } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                    header.add(String.valueOf(cell.getBooleanCellValue()));
                } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                    return header;
                } else {
                    header.add(String.valueOf(cell.getDateCellValue()));
                }
            }
        }
        return header;
    }

}

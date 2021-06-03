package com.hnbcao.demo.poi;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;

import java.io.*;

/**
 * Copyright (C), 2019-2021, 中冶赛迪重庆信息技术有限公司
 * <p>
 * ClassName： HSSWork
 * <p>
 * Description：
 *
 * @author hnbcao
 * @version 1.0.0
 * @date 2021/1/14 下午3:14
 */

public class HSSWork {
    public static void main(String[] args) throws IOException {
        InputStream inp = new FileInputStream("/data/Work/主数据/元数据批量导入模板.xlsx");
        Workbook wb = WorkbookFactory.create(inp);
//        wb.getNumberOfSheets();
        wb.sheetIterator().forEachRemaining(sheet -> {
            int rowNum = sheet.getPhysicalNumberOfRows();
            int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
            for (int j = 0; j < rowNum; j++) {
                Row row = sheet.getRow(j);
                for (short k = 0; k < cellNum; k++) {
                    Cell cell = row.getCell(k);
                    if (cell.getCellType() == CellType.STRING) {
                        System.out.println(cell.getStringCellValue());
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.println(cell.getNumericCellValue());
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        System.out.println(cell.getBooleanCellValue());
                    } else if (cell.getCellType() == CellType.BLANK) {
                        System.out.println("NULL");
                    } else {
                        System.out.println(cell.getDateCellValue());
                    }
                }
                System.out.println("-----------------------------");
            }

        });
        // or new XSSFWorkbook();
//        Sheet sheet1 = wb.createSheet("new sheet");
//        Sheet sheet2 = wb.createSheet("second sheet");
//// Note that sheet name is Excel must not exceed 31 characters
//// and must not contain any of the any of the following characters:
//// 0x0000
//// 0x0003
//// colon (:)
//// backslash (\)
//// asterisk (*)
//// question mark (?)
//// forward slash (/)
//// opening square bracket ([)
//// closing square bracket (])
//// You can use org.apache.poi.ss.util.WorkbookUtil#createSafeSheetName(String nameProposal)}
//// for a safe way to create valid names, this utility replaces invalid characters with a space (' ')
//        String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
//        Sheet sheet3 = wb.createSheet(safeName);
//        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
//            wb.write(fileOut);
//        }
    }
}
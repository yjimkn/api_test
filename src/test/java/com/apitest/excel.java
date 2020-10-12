package com.apitest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excel {
    public static void main(String[] args) {
        String file="E:\\tenzidonghua\\src\\main\\resources\\case.xls";
        excel.read(file);
    }

    public static Object[][] read(String path) {
        Object[][] data = null;
//创建一个 io流 读取
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("地址错误，获取不到文件");
        }
        //转成可阅读形式
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            System.out.println("地址错误，获取不到文件");
        }

        //获取页数
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        data=new Object[lastRowNum][4];
        //获取用例时 不需要表头
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            short lastCellNum = row.getLastCellNum();
            //获取id
            Cell Idcell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            Idcell.setCellType(CellType.STRING);
            String stringCellValue = Idcell.getStringCellValue();
            //获取url
            Cell urlcell = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            urlcell.setCellType(CellType.STRING);
            String Stringurlcell = urlcell.getStringCellValue();
            data[i-1][0]=Stringurlcell;//获取数组下标的第一个值

            //获取type
            Cell typecell = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            typecell.setCellType(CellType.STRING);
            String Stringtypecell = typecell.getStringCellValue();
            data[i-1][2]=Stringtypecell;
            //获取params
            Cell paramscell = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            paramscell.setCellType(CellType.STRING);
            String Stringparamscell = paramscell.getStringCellValue();
            data[i-1][1]=Stringparamscell;//获取数组下标的第二个值
            //获取contentype
            Cell contentypecell = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            contentypecell.setCellType(CellType.STRING);
            String Stringcontentypecell = contentypecell.getStringCellValue();
            data[i-1][3]=Stringcontentypecell;
            System.out.println(
                    stringCellValue + "," + Stringurlcell + "," + Stringtypecell + "," + Stringparamscell + "," + Stringcontentypecell
            );
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}

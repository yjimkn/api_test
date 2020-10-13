package apitest;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.alibaba.fastjson.JSON;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static cn.afterturn.easypoi.excel.ExcelImportUtil.*;

public class excel {
    public static void main(String[] args) {
        String path="D:\\workspace\\Java\\Spring\\JAVAZ\\tenzidonghua\\API_2\\src\\main\\resources\\cases_v3.xlsx";
        List<API> list = excel.read(path, 1, API.class);
        System.out.println(JSON.toJSONString(list));
        List<Case> read = excel.read(path, 2, Case.class);
        System.out.println(JSON.toJSONString(read));

    }


    //待完善
    public static Object[][] getObject(String path){
        List<API> list = excel.read(path, 1, API.class);

        List<Case> read = excel.read(path, 2, Case.class);
        Object [][] ob1 = new Object[list.size()*read.size()][2];
        int[][]a2=new int[2][3];
        API api = null;
        Case params = null;
        int count = 0;
        for (int i=0;i<list.size();i++){
            api= list.get(i);
            for (int j=0;j<read.size();j++){
                params = read.get(j);
                if(params.getAPIid().equals(api.getId())){
                ob1[count][0] = api;
                ob1[count][1] = params;
                    count++;
                }else{

                }
            }
        }
        return ob1;
    }

    public static List<Case> getUrlAndParams(String path){
        List<API> list = excel.read(path, 1, API.class);

        List<Case> read = excel.read(path, 2, Case.class);

        List<Case> listCase = new ArrayList<>();
        API api = null;
        Case params = null;
        for (int i=0;i<list.size();i++){
            api= list.get(i);
            for (int j=0;j<read.size();j++){
                params = read.get(j);

                if(params.getAPIid().equals(api.getId())){
                    params.setApi_url(api.getUrl());
                    params.setApi_name(api.getName());
                    params.setApi_contentType(api.getContentType());
                    params.setApi_type(api.getType());
                    listCase.add(params);
                }
            }
        }
        return listCase;
    }
public static <T> List<T> read(String path,int sheetIndex,Class<T> Clazz) {

//加载excel流对象
    FileInputStream fis = null;
    try {
        fis = new FileInputStream(path);
//导入参数对象
        ImportParams params = new ImportParams();
        params.setNeedVerfiy(true);//防止返回为null
        params.setSheetNum(sheetIndex);
        List<T> importExcel = ExcelImportUtil.importExcel(fis, Clazz, params);
        return importExcel;
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return null;
}
//    public static Object[][] read(String path) {
//        Object[][] data = null;
////创建一个 io流 读取
//        FileInputStream file = null;
//        try {
//            file = new FileInputStream(path);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("地址错误，获取不到文件");
//        }
//        //转成可阅读形式
//        Workbook workbook = null;
//        try {
//            workbook = WorkbookFactory.create(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//            System.out.println("地址错误，获取不到文件");
//        }
//
//        //获取页数
//        Sheet sheet = workbook.getSheetAt(0);
//        int lastRowNum = sheet.getLastRowNum();
//        data=new Object[lastRowNum][4];
//        //获取用例时 不需要表头
//        for (int i = 1; i <= lastRowNum; i++) {
//            Row row = sheet.getRow(i);
//            short lastCellNum = row.getLastCellNum();
//            //获取id
//            Cell Idcell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//            Idcell.setCellType(CellType.STRING);
//            String stringCellValue = Idcell.getStringCellValue();
//            //获取url
//            Cell urlcell = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//            urlcell.setCellType(CellType.STRING);
//            String Stringurlcell = urlcell.getStringCellValue();
//            data[i-1][0]=Stringurlcell;//获取数组下标的第一个值
//
//            //获取type
//            Cell typecell = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//            typecell.setCellType(CellType.STRING);
//            String Stringtypecell = typecell.getStringCellValue();
//            data[i-1][2]=Stringtypecell;
//            //获取params
//            Cell paramscell = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//            paramscell.setCellType(CellType.STRING);
//            String Stringparamscell = paramscell.getStringCellValue();
//            data[i-1][1]=Stringparamscell;//获取数组下标的第二个值
//            //获取contentype
//            Cell contentypecell = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//            contentypecell.setCellType(CellType.STRING);
//            String Stringcontentypecell = contentypecell.getStringCellValue();
//            data[i-1][3]=Stringcontentypecell;
//            System.out.println(
//                    stringCellValue + "," + Stringurlcell + "," + Stringtypecell + "," + Stringparamscell + "," + Stringcontentypecell
//            );
//        }
//        try {
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return data;
//    }

}

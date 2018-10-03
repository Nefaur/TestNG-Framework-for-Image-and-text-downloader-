package com.business.giftrbeta.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter{

public void ExcelWriter(String value) throws IOException {
    FileInputStream fis=new FileInputStream(PropertyReaderService.excelFiletowrite());
    XSSFWorkbook wb= new XSSFWorkbook(fis);

    XSSFSheet sh = wb.getSheetAt(0);
    int lrow=sh.getLastRowNum()+1;
    
    XSSFRow row=sh.createRow(lrow);
    XSSFCell cell= row.createCell(0);
    cell.setAsActiveCell();
    if(cell.getBooleanCellValue()!=false) {
    	int lastrow=sh.getLastRowNum();
    	int i=lastrow+1;
    	
    	row=sh.createRow(i+1);
    
    }
    //cell.setCellType(cell.CELL_TYPE_STRING);
    
    cell.setCellValue(value);

    FileOutputStream fos=new FileOutputStream(PropertyReaderService.excelFiletowrite());
    wb.write(fos);
    
//    fos.close();

    System.out.println("Excel File Written successfully");
}
}
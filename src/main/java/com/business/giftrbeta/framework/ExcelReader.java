package com.business.giftrbeta.framework;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
  
    public void readExcel(int sheetNum) throws IOException{

    //Create an object of File class to open xlsx file

    File filePath =    new File(PropertyReaderService.excelFile());

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(filePath);

    Workbook excelFile = null;

    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileName=PropertyReaderService.filename();
    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    excelFile = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of XSSFWorkbook class

        excelFile = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet workSheet = excelFile.getSheetAt(sheetNum);

    Iterator<Row> iterator = workSheet.iterator();
    
    while (iterator.hasNext()) {
        Row nextRow = iterator.next();
        Iterator<Cell> cellIterator = nextRow.cellIterator();
         
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
             
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    System.out.print(cell.getStringCellValue());
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.print(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue());
                    break;
            }
            System.out.print(" - ");
        }
        System.out.println();
    }
     
    excelFile.close();
    inputStream.close();
}

    

    
}
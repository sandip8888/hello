package home.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook; 

public class ReadExcel {

    public String[] readExcel(String filePath,String fileName,String sheetName) throws IOException {
        String[] credential = new String[2];

        //Create an object of File class to open xlsx file
        File file = new File(filePath+"/"+fileName);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook excelBook = null;

        //Find the file extension by splitting file name in substring  and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file
        //if(fileExtensionName.equals(".xlsx")){

            //If it is xlsx file then create object of XSSFWorkbook class
            //excelBook = new XSSFWorkbook(inputStream);
        //}

        //Check condition if the file is xls file
        if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of HSSFWorkbook class
            excelBook = new HSSFWorkbook(inputStream);
        }

        //Read sheet inside the workbook by its name
        Sheet excelSheet = excelBook.getSheet(sheetName);

        //Find number of rows in excel file
        int rowCount = excelSheet.getLastRowNum()-excelSheet.getFirstRowNum();

        //Create a loop over all the rows of excel file to read it
        for (int i = 0; i < rowCount+1; i++) {
            Row row = excelSheet.getRow(i);

            //Create a loop to print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++) {

                //Print Excel data in console
                credential[j] = row.getCell(j).getStringCellValue();
                //System.out.print(row.getCell(j).getStringCellValue()+"|| ");
            }
        } 
        return credential;
    }  
}
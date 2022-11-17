package com.google.Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelFileReader(String filePath)
	{
		 File testdatafile = new File(filePath);
		 FileInputStream fs = null;
		try {
			fs = new FileInputStream(testdatafile);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		 try {
			wb = new XSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public String getCellValue(int sheetNumber,int row , int col )
	{
		sheet = wb.getSheetAt(sheetNumber);
		DataFormatter formatter = new DataFormatter();
		String cellValue =formatter.formatCellValue((sheet.getRow(row).getCell(col)));
		return cellValue;
		
	}

}
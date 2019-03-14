package com.farmework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;

	public ExcelDataProvider()
	{
		File src=new File(System.getProperty("user.dir")+"/Testdata/testData.xlsx");
		FileInputStream file;
		try {
			file = new FileInputStream(src);
			wb=new XSSFWorkbook(file);
		} catch (Exception e) {
			
			
			System.out.println("Unabe tp excess the file"+e.getMessage());
		}
		
	}
	
	public String getStringData(String sheetname,int rownum,int colom)
	{
		return wb.getSheet(sheetname).getRow(rownum).getCell(colom).getStringCellValue();
	}
	
	public String getStringData(int index,int rownum,int colom)
	{
		return wb.getSheetAt(index).getRow(rownum).getCell(colom).getStringCellValue();
	}
	
	public Number getNumberData(String sheetname,int rownum,int colom)
	{
		return wb.getSheet(sheetname).getRow(rownum).getCell(colom).getNumericCellValue();
	}
}

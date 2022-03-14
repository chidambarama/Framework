package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{
	XSSFWorkbook wb;

	public ExcelDataProvider()
	{
		File src=new File("./testData/data.xlsx");

		try 
		{
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);

		} 

		catch (Exception e)
		{
			System.out.println("unable to read excel data "+e.getMessage());

		}

	}


	public String getStringData(int  Sheetindex, int row, int column)
	{
		return wb.getSheetAt(Sheetindex).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringData(String Sheetname, int row, int column)
	{
		return wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue();
	}

	public void getNumericData(String Sheetname, int row, int column)
	{
		wb.getSheet("").getRow(row).getCell(column).getNumericCellValue();
	}


}




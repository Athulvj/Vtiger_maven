package com.crm.Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 *  its used read the data from excel base don below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = (Sheet) wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(celNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	public String getintDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = (Sheet) wb.getSheet(sheetName);
		DataFormatter dataFormatter = new DataFormatter();
		String Value = dataFormatter.formatCellValue(sh.getRow(rowNum).getCell(celNum));
		return Value;	
	}

	public Object[][] getExcelTestData(String sheetname) throws Throwable, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelTestData);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum();
		int lastcell = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object [lastrow][lastcell];

		for(int i = 0; i<lastrow;i++) {
			for(int j = 0; j<lastcell;j++) {
				
				data [i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}

		}
		return data;

	}

}

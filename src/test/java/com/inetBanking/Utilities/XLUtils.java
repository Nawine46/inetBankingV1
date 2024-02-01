package com.inetBanking.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	
	public static FileInputStream fi;
	
	//public static XSSFWorkbook wb ;
	
	public static XSSFSheet sheet;
	
	public static	XSSFRow row;
	
	public static	XSSFCell cell;
	
	public static	XSSFCell createCell;
	
	
	
	
	 public static int getRowCount(String xlfile ,String xlsheet) throws IOException {
		 
		try  { 
		  fi =new FileInputStream(xlfile);
		 
		  XSSFWorkbook workbook =new XSSFWorkbook(fi);
		 
		 sheet = workbook.getSheet(xlsheet);
		 
		 int rowCount = sheet.getLastRowNum();	
		 
		 fi.close();	
		 
		 return rowCount;
		 
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return 0;
	 }
	
	
	 public static int getCellCount(String xlfile ,String xlsheet ,int rownum) throws IOException  {
		 
		  fi =new FileInputStream(xlfile);
		  
		  XSSFWorkbook workbook  =new XSSFWorkbook(fi);
		 
		  sheet = workbook.getSheet(xlsheet);
		 
		 row = sheet.getRow(rownum);
		 
		 int lastCellNum = row.getLastCellNum();
		 
		 fi.close();
			
		 return lastCellNum;			
		 
		 
	 }
	 
	 public static String getCellData(String xlfile ,String xlsheet ,int rownum , int cellnum) throws IOException {
		 
		 fi =new FileInputStream(xlfile);
		 
		  XSSFWorkbook workbook  =new XSSFWorkbook(fi);
		 
		 sheet = workbook.getSheet(xlsheet);
		 
		 row = sheet.getRow(rownum);
		 
		 cell = row.getCell(cellnum);
		 
		 String data;
		 
		
		try  {
		
		DataFormatter formatter =new DataFormatter();
		
		String cellDate = formatter.formatCellValue(cell);
		 
		return cellDate;
		
		}catch(Exception e) {
			
			
			data="";
			
			
		}
		
		fi.close();
		
		return data;	
		 
	 }
	
	 public void setCellData(String xlfile ,String xlsheet ,int rownum , int cellnum) throws IOException {
		 
		  fi =new FileInputStream(xlfile);
		
		  XSSFWorkbook workbook  =new XSSFWorkbook(fi);
		 
		  sheet = workbook.getSheet(xlsheet);
		 
		 row = sheet.getRow(rownum);
		 
		 createCell = row.createCell(cellnum);
		 
		 //FileOutputStream fo =new FileOutputStream(xlfile);
		 
		 //wb.write(fo);
		 
		 fi.close();
		 
		 
	 }
	 
	
}

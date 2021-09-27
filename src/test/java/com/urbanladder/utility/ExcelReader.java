package com.urbanladder.utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReader {
	public static XSSFSheet xcel() throws IOException
	{
		
		FileInputStream file= new FileInputStream("C:\\Users\\User\\Desktop\\myselenium\\UrbanLadder\\Excel\\manasa.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		int count1=workbook.getNumberOfSheets();
		
		for(int i=0;i<count1;i++)
		{
		XSSFSheet sheet=workbook.getSheetAt(i);
		if(sheet.getSheetName().equals("zzz"))
				{
		return sheet;
		}
		}
		return null;
		
	}

	

	public static int numberofrow(XSSFSheet sheet) {
		// TODO Auto-generated method stub
		int count1=0;
		Iterator<Row>row=sheet.iterator();
		row.next();
		
		while(row.hasNext())
		{
			count1++;
			row.next();
		}
		return count1;
	}
	
	
public static int numberofcol(XSSFSheet sheet)
{
	Iterator<Row>row=sheet.iterator();
	Row first=row.next();
	int count1=0;
	Iterator<Cell>cell=first.cellIterator();
	while(cell.hasNext())
	{
		count1++;
		cell.next();
	}
	return count1;
}

public static Object[][] getdata(XSSFSheet sheet,int rows,int columns)
{
	ArrayList<String> data= new ArrayList<String>();

	
	
	
	Iterator<Row>row=sheet.iterator();
	row.next();
	DataFormatter formatter = new DataFormatter();
	while(row.hasNext())
	{
		Iterator<Cell>cell=row.next().cellIterator();
		while(cell.hasNext())
		{
			Cell pell =cell.next();
			data.add(formatter.formatCellValue(pell));
			
					
		
		
		}
	}
	
	Object[][] objectdata=new Object[rows][columns];
	int k=0;
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<columns;j++)
		{
			objectdata[i][j]=data.get(k);
			k++;
			
		}
	}
	return objectdata;

	
	
	
}

}


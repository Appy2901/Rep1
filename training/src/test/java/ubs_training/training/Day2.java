package ubs_training.training;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Day2 {
	  public static Object[][] testreadExcel()
		{
			Object[][] obj=null;
			File file=new File("resources\\Users.xlsx");
			try {
				InputStream is=new FileInputStream(file);
				XSSFWorkbook workbook=new XSSFWorkbook(is);
				XSSFSheet sheet1=workbook.getSheet("Sheet1");
				obj=new Object[sheet1.getLastRowNum()][];
				for(int i=0;i<sheet1.getLastRowNum();i++)
				{
					obj[i]=new Object[sheet1.getRow(i).getPhysicalNumberOfCells()];
					for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
					{
						
					obj[i][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
					}
					//System.out.println();
				//System.out.println(sheet1.getRow(i).getCell(0).getStringCellValue());
				//System.out.println(sheet1.getRow(i).getCell(1).getStringCellValue());
				}
				workbook.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return obj;
		}
  }

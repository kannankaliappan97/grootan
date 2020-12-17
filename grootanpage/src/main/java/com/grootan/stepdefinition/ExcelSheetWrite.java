package com.grootan.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ExcelSheetWrite {
	
	public void juniourEngineerName(WebDriver driver,String folderLocation) throws Exception {
		File file = new File(folderLocation + "\\src\\test\\resources\\Excelfolder");

		driver.findElement(By.linkText("Team")).click();
		List<WebElement> juniorEngName = driver
				.findElements(By.xpath("//*[contains(text(),\"Junior Engineer\")]/preceding-sibling::h3[@class]"));
		System.out.println(juniorEngName.size());
		String junEngName[] = new String[juniorEngName.size()];
		for (int i = 0; i < juniorEngName.size(); i++) {
			junEngName[i] = juniorEngName.get(i).getText();
		}
		exclewrite(file, "outputFile.xlsx",  junEngName);
	}
	
	public void exclewrite(File filePath, String fileName, String EngName[]) throws Exception{
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
    	XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("JuniorEngineer");		
		XSSFRow row;
		int rowid = 0;
		for (String name : EngName) {
			row = spreadsheet.createRow(rowid++);
			int cellid = 0;
			Cell cell = row.createCell(cellid);
			cell.setCellValue(name);
			}

		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
	}

}

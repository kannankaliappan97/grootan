package com.grootan.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoTestng {
	WebDriver driver;
	ExcelSheetWrite excelsheetwrite;
	HomePageDahboard urlScreenStore;
	String folderLocation = System.getProperty("user.dir");
	 File screenshot = ((TakesScreenshot)
	 driver).getScreenshotAs(OutputType.FILE);

	@BeforeTest
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				folderLocation+"\\src\\test\\resources\\browser\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void application() throws Exception {
		int count = 1;
		driver.get("https://www.grootan.com/ ");
		driver.manage().window().maximize();

		//urlScreenStore.homeTextClick();
		fileFolderCreation(screenshot, count);

		juniourEngineerName();
		driver.close();
	}

	public void juniourEngineerName() throws Exception {
		File file = new File(folderLocation + "\\src\\test\\resources\\Excelfolder");

		driver.findElement(By.linkText("Team")).click();
		List<WebElement> juniorEngName = driver
				.findElements(By.xpath("//*[contains(text(),\"Junior Engineer\")]/preceding-sibling::h3[@class]"));
		System.out.println(juniorEngName.size());
		String junEngName[] = new String[juniorEngName.size()];
		for (int i = 0; i < juniorEngName.size(); i++) {
			junEngName[i] = juniorEngName.get(i).getText();
		}
		excelsheetwrite.exclewrite(file, "outputFile.xlsx",  junEngName);
	}

	public void exclewrite(File filePath, String fileName,  String[] junEngName) throws Exception {
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("JuniorEngineer");
		
		XSSFRow row;
		int rowid = 0;
		for (String name : junEngName) {
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

	public void waitResponse() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
	}

	public void homeTextClick() {
		driver.findElement(By.linkText("Home")).click();
		waitResponse();

	}

	public void fileFolderCreation(File screenshot, int count) {
		String name = "Folder" + count;

		File file = new File(folderLocation + "\\src\\test\\resources\\imgefolder\\" + name);
		if (!file.exists()) {
			file.mkdir();
			try {
				FileUtils.copyFile(screenshot, new File(file + "\\home.png"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else {
			count++;
			fileFolderCreation(screenshot, count);
		}
	}
}

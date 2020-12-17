package com.grootan.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class HomePageDahboard  {
          public WebDriver driver;
	
	public HomePageDahboard(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	String folderLocation = System.getProperty("user.dir");
	
	@FindBy(linkText="Home")
	@CacheLookup
	WebElement home;
	
	@FindBy(linkText="Services")
	@CacheLookup
	WebElement services;
	
	@FindBy(linkText="Open source")
	@CacheLookup
	WebElement openSource;
	
	@FindBy(linkText="Blog")
	@CacheLookup
	WebElement blog;

	@FindBy(linkText="Team")
	@CacheLookup
	WebElement team;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//*[contains(text(),\\\"Junior Engineer\\\")]/preceding-sibling::h3[@class]"))
	List<WebElement> juniourEngName;

	
	@FindBy(linkText="Careers")
	@CacheLookup
	WebElement careers;
	
	@FindBy(linkText="Contact us")
	@CacheLookup
	WebElement contactUs;
	
	public void homeTextCLick() {
			home.click();	
	}
	
	public void servicesTextCLick() {
		services.click();
	}
	
	public void openSourceTextCLick() {
		openSource.click();
	}
	
	public void blogTextCLick() {
		blog.click();
	}
	
	public void teamTextCLick() {
		team.click();
		
	}
	
	public void careersTextCLick() {
		careers.click();
	}
	
	public void contactUsTextCLick() {
		contactUs.click();
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
		exclewrite(file, "outputFile.xlsx",  junEngName);
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
}

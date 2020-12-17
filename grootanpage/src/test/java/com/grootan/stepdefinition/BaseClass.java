package com.grootan.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass  {
	
	 public static WebDriver driver;
	String folderLocation = System.getProperty("user.dir");
	String baseURL="https://www.grootan.com/";
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
               folderLocation+"\\src\\test\\resources\\browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	
	
	
	public File fileFolderCreation(int folderCoutn) {
		
		String name = "Folder" + folderCoutn;
		File file = new File(folderLocation + "\\src\\test\\resources\\imgefolder\\" + name);
		if (!file.exists()) {
			file.mkdir();
		} else {
			folderCoutn++;
			fileFolderCreation(folderCoutn);
		}
		return file;
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(fileFolderCreation(0)+ "" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}

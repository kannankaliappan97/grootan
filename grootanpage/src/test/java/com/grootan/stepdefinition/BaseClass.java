package com.grootan.stepdefinition;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class BaseClass {

	
	public static WebDriver driver;
	static String folderLocation = System.getProperty("user.dir");
	static String baseURL = "https://www.grootan.com/";
	String folderPath = folderLocation + "\\src\\test\\resources\\imgefolder\\";
	File folderDirectoryPath = new File(folderLocation);
	SoftAssert softAssertion = new SoftAssert();
	Map<Integer, Object[]> imgComapreInfo = new LinkedHashMap<Integer, Object[]>();
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				folderLocation + "\\src\\test\\resources\\browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

	public void fileFolderCreation(int folderCount) {
		String name = "Folder" + folderCount;
		File file = new File(folderPath + name);
		if (!file.exists()) {
			file.mkdir();

		} else {
			folderCount++;
			fileFolderCreation(folderCount);
		}
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		File directoryPath = new File(folderPath);
		String contents[] = directoryPath.list();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(folderPath + contents[contents.length - 1] + "\\" + tname + ".png");
		FileUtils.copyFile(source, target);
	}

	public void folderImageComparision() throws Exception {
		File folderDirectoryPath = new File(folderPath);
		String folderDirectorySize[] = folderDirectoryPath.list();
		int folderDirectoryLength = folderDirectorySize.length + 1;
		File imageFolderOne = new File(folderPath + "Folder1\\");
		File imageFolderTwo = new File(folderPath + "Folder2\\");
		String firstImageFolderItems[] = imageFolderOne.list();
		String secondImageFolderItems[] = imageFolderTwo.list();
		if (folderDirectoryPath.exists()) {
			if (imageFolderOne.exists() && imageFolderTwo.exists()) {
				for (String firstFileName : firstImageFolderItems) {
					for (String secondFileName : secondImageFolderItems) {
						BufferedImage expectedImage = ImageIO.read(new File(imageFolderOne + firstFileName));
						BufferedImage actualImage = ImageIO.read(new File(imageFolderTwo + secondFileName));
						ImageDiffer imgDiff = new ImageDiffer();
						ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
						if (diff.hasDiff()) {
						softAssertion.assertEquals(diff.hasDiff(), true, "both have different Image");
						}						
					}
				}
			} else {
				Assert.assertFalse(!(imageFolderOne.exists() && imageFolderTwo.exists()));
			}
		} else {
			Assert.assertFalse(!folderDirectoryPath.exists());
		}

	}


}

package com.grootan.stepdefinition;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class HomePageDashBoardPage extends BaseClass {

	public HomePageDashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	String folderLocation = System.getProperty("user.dir");

	File file = new File(folderLocation + "\\src\\test\\resources\\Excelfolder\\outputFile.xlsx");

	Map<String, Object[]> TestNGResults = new LinkedHashMap<String, Object[]>();;

	String url_Verification;

	@FindBy(linkText = "Home")
	WebElement home;

	@FindBy(linkText = "Services")
	WebElement services;

	@FindBy(linkText = "Open Source")
	WebElement openSource;

	@FindBy(linkText = "Blog")
	WebElement blog;

	@FindBy(linkText = "Team")
	WebElement team;

	@FindBy(xpath = "//*[contains(text(),\\\"Junior Engineer\\\")]/preceding-sibling::h3[@class]")
	List<WebElement> juniourEngName;

	@FindBy(xpath = "//img[@src =\"img/testimonials/sasi.jpg\"]")
	WebElement hrManager;

	@FindBy(xpath = "//img[@src =\"img/testimonials/lokesh.jpg\"]")
	WebElement co_And_Cto;

	@FindBy(linkText = "Careers")
	WebElement careers;

	@FindBy(linkText = "Contact Us")
	WebElement contactUs;

	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet spreadDheetForTCS = workbook.createSheet("TSR");
	HSSFSheet spreadsheetForENgName = workbook.createSheet("JuniorEngineer");
	HSSFSheet spreadCoAndHrImageCompare = workbook.createSheet("CO&HRImage");

	public void homeTextCLick() {
		TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });

		home.click();
		url_Verification = driver.getCurrentUrl();
		boolean url_verified = url_Verification.equalsIgnoreCase("https://www.grootan.com/") ? true : false;
		try {
			Assert.assertTrue(url_verified);
			TestNGResults.put("2", new Object[] { 1d, "Navigate to Home website", "Site gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("2", new Object[] { 1d, "Navigate to Home website", "Can not Site opened", "Fail" });

		}

	}

	public void servicesTextCLick() {
		services.click();
		url_Verification = driver.getCurrentUrl();
		boolean url_verified = url_Verification.equalsIgnoreCase("https://www.grootan.com/#built-tech") ? true : false;
		try {
			Assert.assertTrue(url_verified);
			TestNGResults.put("3", new Object[] { 2d, "Navigate to Services Page", "Site gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("3", new Object[] { 2d, "Navigate to Services Page", "Site gets opened", "fail" });
		}

	}

	public void openSourceTextCLick() {
		openSource.click();
		url_Verification = driver.getCurrentUrl();
		boolean url_verified = url_Verification.equalsIgnoreCase("https://www.grootan.com/opensource") ? true : false;
		try {
			Assert.assertTrue(url_verified);
			TestNGResults.put("4", new Object[] { 3d, "Navigate to Open Source Page", "Site gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("4", new Object[] { 3d, "Navigate to Open Source Page", "Can not Site opened", "Fail" });
			Assert.assertFalse(false);
		}
	}

	public void blogTextCLick() {
		blog.click();
		url_Verification = driver.getCurrentUrl();

		boolean url_verified = url_Verification.equalsIgnoreCase("https://blog.grootan.com/") ? true : false;
		try {
			Assert.assertTrue(url_verified);
			TestNGResults.put("5", new Object[] { 4d, "Navigate to Blog Page", "Page gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("5", new Object[] { 4d, "Navigate to Blog Page", "Can not Page opened", "Fail" });
			Assert.assertFalse(false);
		}
	}

	public void teamTextCLick() throws Exception {
		team.click();
		url_Verification = driver.getCurrentUrl();
		boolean url_verified = url_Verification.equalsIgnoreCase("https://www.grootan.com/team") ? true : false;
		try {
			Assert.assertTrue(url_verified);
			TestNGResults.put("6", new Object[] { 5d, "Navigate to Team Page", "Page gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("6", new Object[] { 5d, "Navigate to Team Page", "Can not Page opened", "Fail" });
			Assert.assertFalse(false);
		}

	}

	public void careersTextCLick() {
		careers.click();
		url_Verification = driver.getCurrentUrl();
		boolean url_verified = url_Verification.equalsIgnoreCase("https://www.grootan.com/careers") ? true : false;
		try {
			Assert.assertTrue(url_verified);
			TestNGResults.put("7", new Object[] { 6d, "Navigate to Careers Page", "Page gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("7", new Object[] { 6d, "Navigate to Careers Page", "Can not Page opened", "Fail" });
			Assert.assertFalse(false);
		}

	}

	public void contactUsTextCLick() {
		contactUs.click();
		url_Verification = driver.getCurrentUrl();
		boolean url_verified = url_Verification.equalsIgnoreCase("https://www.grootan.com/contactus") ? true : false;
		try {
			Assert.assertTrue(url_verified);
			TestNGResults.put("8", new Object[] { 7d, "Navigate to ContactUS Page", "Page gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("8", new Object[] { 7d, "Navigate to ContactUS Page", "Can not Page opened", "Fail" });
			Assert.assertFalse(false);
		}
	}

	public void juniourEngineerName() throws Exception {
		List<WebElement> juniorEngName = driver
				.findElements(By.xpath("//*[contains(text(),\"Junior Engineer\")]/preceding-sibling::h3[@class]"));
		String junEngName[] = new String[juniorEngName.size()];
		for (int i = 0; i < juniorEngName.size(); i++) {
			junEngName[i] = juniorEngName.get(i).getText();
		}
		excleWriteJunEngName(junEngName);
	}

	public void excleWriteJunEngName(String[] junEngName) throws Exception {
		FileInputStream inputStream = new FileInputStream(file);
		spreadsheetForENgName = workbook.getSheet("JuniorEngineer");
		Row row;
		int rowid = 0;
		for (String name : junEngName) {
			row = spreadsheetForENgName.createRow(rowid++);
			int cellid = 0;
			Cell cell = row.createCell(cellid);
			cell.setCellValue(name);
		}
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
	}

	public void excelWriteTSRSheet() throws IOException {
		FileInputStream inputStream = new FileInputStream(file);
		spreadDheetForTCS = workbook.getSheet("TSR");
		spreadCoAndHrImageCompare = workbook.getSheet("CO&HRImage");
		Set<String> KeySetData = TestNGResults.keySet();
		int rowcount = 0;
		for (String keySet : KeySetData) {
			Row row = spreadDheetForTCS.createRow(rowcount++);
			Object[] objectList = TestNGResults.get(keySet);
			int cellnum = 0;
			for (Object splitData : objectList) {
				Cell cell = row.createCell(cellnum++);
				if (splitData instanceof String) {
					cell.setCellValue((String) splitData);
				} else if (splitData instanceof Boolean)
					cell.setCellValue((Boolean) splitData);
				else if (splitData instanceof Double)
					cell.setCellValue((Double) splitData);
			}
		}

		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();

	}

	public void contactUspageClick() throws Exception {
		contactUsTextCLick();
		captureScreen(driver, "ContactUS");
	}

	public void careerPageClick() throws Exception {
		careersTextCLick();
		captureScreen(driver, "Career");
	}

	public void teamPageClick() throws Exception {
		teamTextCLick();
		juniourEngineerName();
		captureScreen(driver, "Team");
	}

	public void blogPageCLick() throws Exception {
		blogTextCLick();
		captureScreen(driver, "Blog");

	}

	public void openSourcePageClick() throws Exception {
		openSourceTextCLick();
		captureScreen(driver, "OpenSource");
	}

	public void servicesPageClick() throws Exception {
		servicesTextCLick();
		captureScreen(driver, "Services");
	}

	public void homepageClick() throws Exception {
		homeTextCLick();
		captureScreen(driver, "Home");
	}

	public void juniourEngList() throws Exception {
		team.click();
		juniourEngineerName();
	}

	public void coImageCompare() {
		team.click();
		peopleImageCompare();
	}

	private void peopleImageCompare() {
		Screenshot hrImage = new AShot().takeScreenshot(driver, hrManager);
		BufferedImage actualImage = hrImage.getImage();
		Screenshot coImage = new AShot().takeScreenshot(driver, co_And_Cto);
		BufferedImage expectedImage = coImage.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Assert.assertTrue(diff.hasDiff());

	}

}

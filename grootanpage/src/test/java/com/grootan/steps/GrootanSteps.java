package com.grootan.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

public class GrootanSteps extends PageObject {
	@FindBy(linkText = "Home")
	WebElement home;

	WebDriver driver;

	public void launchApplication() {
		System.setProperty("webdriver.chrom.driver", "/grootanpage/src/test/resources/browser/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.grootan.com/ ");

	}
	public void homeTextClick() {
		home.click();
	}

}

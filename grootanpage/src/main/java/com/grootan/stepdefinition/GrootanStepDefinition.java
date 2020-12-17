package com.grootan.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.grootan.steps.GrootanSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;

public class GrootanStepDefinition extends PageObject {
	@Steps
	GrootanSteps grootanSteps;
	@FindBy(linkText = "Home")
	WebElement home;
	
	WebDriver driver;
	@Given("I want to lang the grootan home page")
	public void i_want_to_lang_the_grootan_home_page() {
		System.setProperty("webdriver.chrom.driver", "/grootanpage/src/test/resources/browser/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.grootan.com/ ");
	}

	@When("naviaget the diffrent page")
	public void naviaget_the_diffrent_page() {
	home.click();    
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	   
	    driver.close();
	}

}

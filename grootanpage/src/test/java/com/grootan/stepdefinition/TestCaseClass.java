
package com.grootan.stepdefinition;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseClass extends BaseClass {
	
	HomePageDashBoardPage urlPage;
	
	@BeforeTest
	public static void setUp() {
		launchBrowser();
	}
	
	
	@Test (priority =1 )
	public void screenShort() throws Exception {
		int folderCount =1;
		fileFolderCreation(folderCount);
		urlPage = new HomePageDashBoardPage();
		urlPage.homepageClick();
		urlPage.servicesPageClick();
		urlPage.openSourcePageClick();
		urlPage.blogPageCLick();
		urlPage.teamPageClick();
		urlPage.careerPageClick();		
		urlPage.contactUspageClick();
	}
	@Test(priority =2 )
	public void candidateList() throws Exception {
		urlPage.juniourEngList();
	}
	
	@Test(priority =3)
	public void co_CTOAndHrImage() throws Exception {
		urlPage.coImageCompare();
		folderImageComparision();
	}
	

	@AfterTest
	public  void tearDown() throws Exception {
		urlPage.excelWriteTSRSheet();
		closeBrowser();
	}


}

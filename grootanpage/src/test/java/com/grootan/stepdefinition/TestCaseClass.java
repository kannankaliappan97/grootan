
package com.grootan.stepdefinition;

import java.io.IOException;

import org.testng.annotations.Test;

public class TestCaseClass extends BaseClass {
	
	HomePageDahboard urlPage;
	
	@Test 
	public void screenShort() throws Exception {
		int folderCoutn =1;
		fileFolderCreation(folderCoutn);
		homepageClick();
	    servicesPageClick();
		openSourcePageClick();
		blogPageCLick();
		teamPageClick();
		careerPageClick();		
		contactUspageClick();
		
	}

	public void contactUspageClick() throws Exception {
		urlPage.contactUsTextCLick();
		captureScreen(driver, "ContactUS");
		
	}

	public void careerPageClick()throws Exception {
		urlPage.careersTextCLick();
		captureScreen(driver, "Career");
	}

	public void teamPageClick() throws Exception {
		urlPage.teamTextCLick();
		urlPage.juniourEngineerName();
		captureScreen(driver, "Team");
	}

	private void blogPageCLick() throws Exception {
		urlPage.blogTextCLick();
		captureScreen(driver, "Blog");
		
	}

	private void openSourcePageClick() throws Exception {
		urlPage.openSourceTextCLick();
		captureScreen(driver, "OpenSource");
	}

	public void servicesPageClick() throws Exception {
		urlPage.servicesTextCLick();
		captureScreen(driver, "Services");
	}

	public void homepageClick() throws Exception {
		urlPage.homeTextCLick();
		captureScreen(driver, "Home");
		
		
		
		
	}

}

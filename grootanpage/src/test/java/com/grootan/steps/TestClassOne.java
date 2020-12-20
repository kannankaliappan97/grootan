package com.grootan.steps;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.automationtesting.excelreport.Xl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClassOne {
	
	 
	
	    @Test
	    public void testMethodPass()
	    {
	     Assert.assertTrue(true);
	    }
	     
	    @Test
	    public void testMethodFail()
	    {
	     Assert.assertTrue(false);
	    }
	     
	    @Test
	    public void testMethodSkip()
	    {
	     throw new SkipException("Skipped Intentionally");
	    }
	    @AfterSuite
	    public void testReort() throws Exception {
	    	Xl.generateReport("testReport");
	    
	    }
	}

	
	
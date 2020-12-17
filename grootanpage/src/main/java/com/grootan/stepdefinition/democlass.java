package com.grootan.stepdefinition;

import java.io.File;

import net.thucydides.core.pages.PageObject;

public class democlass extends PageObject {

	public static void main(String[] args) throws InterruptedException {
	
		
      
		/*System.setProperty("webdriver.chrome.driver", "F:\\GrootanProject\\src\\test\\resources\\browser\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.grootan.com/ ");
		driver.manage().window().maximize();
		
		 driver.findElement(By.linkText("Home")).click();
		 System.out.print(driver.getCurrentUrl());
		 Thread.sleep(2000);
		 driver.close();*/
		
		//System.out.println(methodnaem);
		System.out.println( System.getProperty("user.dir"));
		int count =1;
		filecreation(count);	
       
	}

	private static void filecreation(int count) {
		String name = "Folder"+count;
		File file = new File("F:\\GrootanProject\\src\\test\\java\\com\\"+name);
		if(!file.exists()) {
			file.mkdir();
			
			
		}else {
			String dir = file.toString();
			
		count++;
			filecreation(count);
			
			
			
		}
		
	}

	

}

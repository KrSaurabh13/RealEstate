package com.training.realestate.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_RETC;
import com.training.pom.View_added_Property_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_033_view_added_property {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_RETC LoginPOM_RETC;
	private View_added_Property_POM View_added_Property_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM_RETC = new LoginPOM_RETC(driver); 
		View_added_Property_POM = new View_added_Property_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		screenShot.captureScreenShot();
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void Login_Test() {
		LoginPOM_RETC.clickLogIn_Register_Btn();
		LoginPOM_RETC.clickLogin_Tab();
		LoginPOM_RETC.sendUserName("saurabh@gmail.com");
		LoginPOM_RETC.sendPassword("Saurabh@123");
			screenShot.captureScreenShot();
		LoginPOM_RETC.clickSignInBtn();
		View_added_Property_POM.Mouse_Over_Click_Properties();
		View_added_Property_POM.Click_AddNew();	
		View_added_Property_POM.sendTitleText("new launch", "new launch");
		View_added_Property_POM.Click_Publish();
		View_added_Property_POM.VerifyPageTitle();		
			screenShot.captureScreenShot();
	
	
	}
}

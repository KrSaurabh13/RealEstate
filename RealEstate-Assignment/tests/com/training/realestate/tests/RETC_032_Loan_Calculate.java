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
import com.training.pom.Loan_Calculate_POM;
import com.training.pom.Add_New_Property_POM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_032_Loan_Calculate {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_RETC LoginPOM_RETC;
	private Loan_Calculate_POM Loan_Calculate_POM;
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
		Loan_Calculate_POM = new Loan_Calculate_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		screenShot.captureScreenShot();
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void RegistrationTest() {
		LoginPOM_RETC.clickLogIn_Register_Btn();
		LoginPOM_RETC.clickLogin_Tab();
		LoginPOM_RETC.sendUserName("saurabh@gmail.com");
		LoginPOM_RETC.sendPassword("Saurabh@123");
			screenShot.captureScreenShot();
		LoginPOM_RETC.clickSignInBtn();
			screenShot.captureScreenShot();
			Loan_Calculate_POM.sendEmail("selenium@gmail.com");
			Loan_Calculate_POM.sendFirstName("selenium");
			Loan_Calculate_POM.clickRegisterBtn();
			Loan_Calculate_POM.clickRegisterBtn2();
			screenShot.captureScreenShot();
	
	
	}
}

package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Loan_Calculate_POM {
	private WebDriver driver; 
	
	public Loan_Calculate_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="LOG IN / REGISTER")
	private WebElement LogIn_Register_Btn; 
	
	public void clickLogIn_Register_Btn() {
		System.out.println("LogIn screen is displayed");
		this.LogIn_Register_Btn.click(); 
	}
	
	@FindBy(linkText="Register")
	private WebElement Register_Tab;
	
	@FindBy(xpath="//*[@id='email']")
	private WebElement email; 
	
	@FindBy(xpath="//*[@id='first-name']")
	private WebElement firstname;
	
	@FindBy(xpath="//*[@id='last-name']")
	private WebElement lastname;
	
	@FindBy(xpath="//*[@name='submit']")
	private WebElement RegisterBtn; 
	
	@FindBy(xpath="//*[@id='signupform']/p[5]/input")
	private WebElement RegisterBtn2;
	

	
	public void clickRegister_Tab() {
		this.Register_Tab.click(); 
		System.out.println("Registration screen is displayed");
	}
	
	public void sendEmail(String emailId) {
		this.email.clear();
		this.email.sendKeys(emailId);
		System.out.println("Entered credentials in Email --> " + this.email.getAttribute("value"));
	}
	
	public void sendFirstName(String FirstName) {
		this.firstname.clear(); 
		this.firstname.sendKeys(FirstName); 
		System.out.println("Entered credentials in First Name --> " + this.firstname.getAttribute("value"));
	}
	
	public void sendLastName(String LastName) {
		this.lastname.clear(); 
		this.lastname.sendKeys(LastName); 
		System.out.println("Entered credentials in Last Name --> " + this.lastname.getAttribute("value"));
	}
	
	public void clickRegisterBtn() {
		this.RegisterBtn.click(); 
	}
	
	public void clickRegisterBtn2() {
		this.RegisterBtn2.click(); 
	}
	
	
}

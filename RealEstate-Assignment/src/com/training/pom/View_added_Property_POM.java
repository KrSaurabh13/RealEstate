package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class View_added_Property_POM {
	private WebDriver driver; 
	
	public View_added_Property_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[contains(text(),'Properties')]")
	private WebElement Properties;
	
	
	@FindBy(xpath="//a[@href='post-new.php?post_type=property']")
	private WebElement Add_New;
	
	@FindBy(xpath="//*[@id='title']")
	private WebElement Add_New_Title;
	
	@FindBy(xpath="//*[@id='tinymce']")
	private WebElement Add_New_Text;
	
	
	@FindBy(xpath="//*[@id='publish']")
	private WebElement Publish;
	
	
	public void Mouse_Over_Click_Properties(){
		WebElement pro = Properties;
		Actions act = new Actions(driver);
		act.moveToElement(pro).build().perform();
	}
	
	
	public void Click_AddNew(){
		this.Add_New.click();
		
	}
	
	
	public void sendTitleText(String title, String text) {
		this.Add_New_Title.clear();
		this.Add_New_Title.sendKeys(title);
		this.Add_New_Text.clear();
		this.Add_New_Text.sendKeys(text);
	}
	
	
	public void Click_Publish(){
		this.Publish.click();
		
	}
	
	
	public void VerifyPageTitle() {
	    String Expected = "Add Property ‹ Real Estate — WordPress";
	    String Actual = driver.getTitle();
	    System.out.println("Page Tittle is --> " + driver.getTitle());
	    assertEquals(Actual, Expected);
	}
	
	
		
	
}

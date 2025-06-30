package AMIT.TCS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.Reusable;

public class Login_POM extends Reusable {
	WebDriver driver;
	public Login_POM(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement user;
	
	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement pass;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement Submit;
public void URL() {
	driver.get("https://rahulshettyacademy.com/client");
	driver.manage().window().maximize();
}
	public void credentials(String user1, String pass1) {


		user.sendKeys(user1);
		pass.sendKeys(pass1);
		Submit.click();
	}
	
	

}

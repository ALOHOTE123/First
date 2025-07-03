package Shetty.Rahuls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.Abstractt;

public class LoginPage extends Abstractt {
	WebDriver driver;

	/*driver.get("https://rahulshettyacademy.com/client");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("am@gmail.com");
    driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Automation@9898");
    driver.findElement(By.xpath("//input[@type='submit']")).click();*/
    
    public LoginPage(WebDriver driver) {
    	super(driver);
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    @FindBy(id="userEmail")
    WebElement user;
    @FindBy(id="userPassword")
	WebElement pass;
    @FindBy(id="login")
    WebElement submit;
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
    public Catalog loginApp(String userName,String passwordd) {
    user.sendKeys(userName);
    pass.sendKeys(passwordd);
    submit.click();
    Catalog catalog= new Catalog(driver);
	return catalog;
    }
    public void URL() {
    	driver.get("https://rahulshettyacademy.com/client");
    }
    public String getErrorMessage() {
    	waitForWebElementToAppear(errorMessage);
    	return errorMessage.getText();
    	
    }
	}

	


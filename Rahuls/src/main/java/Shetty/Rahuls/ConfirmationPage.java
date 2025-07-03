package Shetty.Rahuls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.Abstractt;

public class ConfirmationPage extends Abstractt {
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	//String finall= driver.findElement(By.cssSelector(".line-item div:nth-of-type(1)")).getText();
	//remember how you find thi css .line-item div:nth-of-type(1) it will be helpful
	@FindBy(css=".hero-primary")
	WebElement confimationMessge;
	
	public String verifyConfirmationMessage() {
		return confimationMessge.getText();
	}
	
	

}

package Shetty.Rahuls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractcomponents.Abstractt;

public class Checkout extends Abstractt{
	WebDriver driver;
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By countrySearch=By.cssSelector(".ta-results");
	/*driver.findElement(By.cssSelector(".form-group input")).sendKeys("India");
	Actions a = new Actions(driver);
	 //this line is not of use its same backup for same step-a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "India").build().perform();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

	WebElement country= driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)"));
	a.moveToElement(country).click().build().perform();*/
	
	//WebElement submit= driver.findElement(By.cssSelector(".btnn i"));
	//a.moveToElement(submit).click().build().perform();
	
	@FindBy(css=".form-group input")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement countryName;
	
	@FindBy(css=".btnn i")
	WebElement submit;
	
  public void checkoutPage(String countryNamee) {
	 country.sendKeys(countryNamee);
	 Actions a = new Actions(driver);
	 waitForElementToAppear(countrySearch);
	 a.moveToElement(countryName).click().build().perform();
	 
	  
	  
  }
  public ConfirmationPage submitOrder() {
	  Actions a = new Actions(driver);
	  a.moveToElement(submit).click().build().perform();
	  return new ConfirmationPage(driver);
  }
}

package AMIT.TCS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.Reusable;

public class Paymentpage extends Reusable {
	WebDriver driver;
	public Paymentpage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css = ".form-group input")
	WebElement country;
	
	@FindBy(css = ".ta-results button:nth-of-type(2)")
	WebElement dropdownIndia;
	
	@FindBy(css = ".btnn i")
	WebElement submit;

	public void countryclick(String countryy)
	{
	country.sendKeys(countryy);
	Actions a = new Actions(driver);	
	a.moveToElement(dropdownIndia).click().build().perform();
	a.moveToElement(submit).click().build().perform();
}
}

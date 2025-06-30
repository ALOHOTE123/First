package AMIT.TCS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import reuse.Reusable;

public class PlacedPage extends Reusable {
	WebDriver driver;
	public PlacedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	@FindBy(css = ".hero-primary")
	WebElement Thanksmessage;
public String Thankss(){
	return Thanksmessage.getText();
}
}

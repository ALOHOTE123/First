package Shetty.Rahuls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.Abstractt;

public class Cartpage extends Abstractt {
	WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = ("//div[@class='cartSection']//h3"))
	List<WebElement> Mycart;
	
	//checkout-driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public boolean productNameCheck(String productName) {
	 boolean match= Mycart.stream().anyMatch(namee->namee.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		return match;
	}
	public Checkout checkoutbutton() {
		checkout.click();
		 Checkout c= new Checkout(driver);
		 return c;
	}
	//List<WebElement> Mycart= driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
	//boolean match= Mycart.stream().anyMatch(namee->namee.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));

}

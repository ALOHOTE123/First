package AMIT.TCS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import reuse.Reusable;

public class CatalogPage extends Reusable {
	WebDriver driver;
	public CatalogPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath = "(//div[@class='cart']//h3)[1]")
	List<WebElement> cartt;
	
	@FindBy(xpath = "//div[@class='subtotal cf ng-star-inserted']//button")
	WebElement checkout;
	
	public boolean Afteradding(String prod1) {
		//List<WebElement> cartt=driver.findElements(By.xpath("(//div[@class='cart']//h3)[1]"));
		 boolean Cartprod= cartt.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(prod1));
		 return Cartprod;
	}
	public void checkoutButton() {
		checkout.click();
	}


}

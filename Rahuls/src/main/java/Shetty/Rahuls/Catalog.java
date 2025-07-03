package Shetty.Rahuls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.Abstractt;

public class Catalog extends Abstractt {
	WebDriver driver;
	public Catalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(css = ".col-lg-4")
List<WebElement> Prod;
By prodlist=By.cssSelector(".col-lg-4");
By addToCart=By.cssSelector(".card-body button:last-of-type");
By toastMessage=By.cssSelector("#toast-container");


@FindBy(css=".ng-animating")
WebElement spinner;

public List<WebElement> productlist() {
	waitForElementToAppear(prodlist);
	return Prod;
}
public WebElement getProductname(String productName) {
	WebElement name=  productlist().stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	return name;
	
}
public void addProductToCart(String productName) {
	WebElement name=getProductname(productName);
	 name.findElement(addToCart).click();
	 waitForElementToAppear(toastMessage);
	 waitForElementToDisappear(spinner);
}
}

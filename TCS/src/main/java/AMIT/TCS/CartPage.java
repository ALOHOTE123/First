package AMIT.TCS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import reuse.Reusable;

public class CartPage extends Reusable {
	WebDriver driver;
	By allprod=By.cssSelector(".col-lg-4");
	By ButtonClick= By.cssSelector(".card-body button:nth-of-type(2)");
	By Toast=By.cssSelector("#toast-container");
	
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css = ".col-lg-4")
List<WebElement> cartsprod;
	
	@FindBy(css = ".ng-animating")
	WebElement buffer;
	
	public List<WebElement> Allprod() {
		Productsss(allprod);
		return cartsprod;
	}
	public WebElement productFind(String name) {
		
	WebElement prod= Allprod().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
	return prod;

	}
	public void productClick(String name) {
		WebElement nameProd= productFind(name);
		nameProd.findElement(ButtonClick).click();
		  //prod.findElement(By.cssSelector(".card-body button:nth-of-type(2)")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		Productsss(Toast);
		InvisiblytyCheckofProduct(buffer);
		reusableCartClick();
	
	}
	
	
}

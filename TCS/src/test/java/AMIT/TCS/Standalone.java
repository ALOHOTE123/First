package AMIT.TCS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import reuse.Reusable;

public class Standalone extends BaseTest {
		

		@Test
		public void stand() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String prod1="ADIDAS ORIGINAL";
	L.credentials("am@gmail.com", "Automation@9898");
	CartPage c= new CartPage(driver);
	 c.Allprod();	 c.productFind(prod1);
	//driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("am@gmail.com");
	//driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Automation@9898");
	//driver.findElement(By.xpath("//input[@type='submit']")).click();
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
//List<WebElement> Productss= driver.findElements(By.cssSelector(".col-lg-4"));
	//WebElement prod= Productss.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
	//prod.findElement(By.cssSelector(".card-body button:nth-of-type(2)")).click();
	//(//div[@class='card-body'])[2]//button this will work
	
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	//instead of invisibilityofelementlocated use this invisibilty of to overcome perfomance issue
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	 c.productClick(prod1);
	 CatalogPage C1= new CatalogPage(driver);
	 boolean cartprod= C1.Afteradding(prod1);
	 Assert.assertTrue(cartprod);
	 C1.checkoutButton();
	 //for git
	 //hang///
	//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	//List<WebElement> cartt=driver.findElements(By.xpath("(//div[@class='cart']//h3)[1]"));
	 //boolean Cartprod= cartt.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(prod1));
	//Assert.assertTrue(Cartprod);
	 //directly can use equalingorecase then question is in first stream ca we use it?
	//driver.findElement(By.xpath("//div[@class='subtotal cf ng-star-inserted']//button")).click();
	 Paymentpage p = new Paymentpage(driver);
	 p.countryclick("India");
	//driver.findElement(By.cssSelector(".form-group input")).sendKeys("India");
	//Actions a = new Actions(driver);
	
	//WebElement dropdownIndia= driver.findElement(By.cssSelector(".ta-results button:nth-of-type(2)"));
	
	//a.moveToElement(dropdownIndia).click().build().perform();
	//WebElement submit= driver.findElement(By.cssSelector(".btnn i"));
	//a.moveToElement(submit).click().build().perform();
	 PlacedPage p1= new PlacedPage(driver);
	String mess= p1.Thankss();
	//String Thanksmessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertEquals(mess, "THANKYOU FOR THE ORDER.");
	System.out.println(mess);
	
		
}
}
package Shetty.Rahuls;

import java.awt.Desktop.Action;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Backup {
	public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    LoginPage L= new LoginPage(driver);
    driver.get("https://rahulshettyacademy.com/client");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("am@gmail.com");
    driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Automation@9898");
    driver.findElement(By.xpath("//input[@type='submit']")).click();
   List<WebElement> Prod= driver.findElements(By.cssSelector(".col-lg-4"));
 WebElement name=  Prod.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
 name.findElement(By.cssSelector(".card-body button:last-of-type")).click();
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
String cartn= driver.findElement(By.xpath("//div[@class='cartSection']//h3")).getText();
Assert.assertEquals(cartn, "ADIDAS ORIGINAL");
List<WebElement> Mycart= driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
boolean match= Mycart.stream().anyMatch(namee->namee.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
Assert.assertTrue(match);
driver.findElement(By.cssSelector(".totalRow button")).click();
driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("123");
Actions a = new Actions(driver);
driver.findElement(By.cssSelector(".form-group input")).sendKeys("India");
 //a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "India").build().perform();
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

WebElement country= driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)"));
a.moveToElement(country).click().build().perform();
WebElement submit= driver.findElement(By.cssSelector(".btnn i"));
a.moveToElement(submit).click().build().perform();
String finall= driver.findElement(By.cssSelector(".line-item div:nth-of-type(1)")).getText();
Assert.assertEquals(finall, "ADIDAS ORIGINAL");
String thankss=driver.findElement(By.cssSelector(".hero-primary")).getText();
System.out.println(thankss);
Assert.assertTrue(thankss.equalsIgnoreCase("Thankyou for the order."));
driver.close();

 
    
		
	}
	

}

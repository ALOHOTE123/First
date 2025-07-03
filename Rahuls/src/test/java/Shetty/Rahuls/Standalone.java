package Shetty.Rahuls;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import Shetty.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Standalone extends BaseTest {
@Test
public void submitOrder() throws IOException {
	
	
		String productName="ADIDAS ORIGINAL";
    
   Catalog catalog= L.loginApp("am@gmail.com", "Automation@9898");
    
    
   List<WebElement> Prod= catalog.productlist();
   catalog.addProductToCart(productName);
   Cartpage cartpage= catalog.goToCartPage();
   
   boolean match =cartpage.productNameCheck(productName);
   Assert.assertTrue(match);
   Checkout c= cartpage.checkoutbutton();
   c.checkoutPage("India");
   ConfirmationPage confirmation= c.submitOrder();
 


//String cartn= driver.findElement(By.xpath("//div[@class='cartSection']//h3")).getText();
//Assert.assertEquals(cartn, "ADIDAS ORIGINAL");
//Assert.assertTrue(match);
//driver.findElement(By.cssSelector(".totalRow button")).click();
//driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("123");

//String finall= driver.findElement(By.cssSelector(".line-item div:nth-of-type(1)")).getText();
//Assert.assertEquals(finall, "ADIDAS ORIGINAL");
   String finall= confirmation.verifyConfirmationMessage();
System.out.println(finall);
Assert.assertTrue(finall.equalsIgnoreCase("Thankyou for the order."));

 
}

		
	}
	

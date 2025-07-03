package abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Shetty.Rahuls.Cartpage;

public class Abstractt {
	WebDriver driver;
 public Abstractt(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
 }
 @FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
 WebElement cartHeader;
 
 public void waitForElementToAppear(By findby) { 
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
}
 public void waitForWebElementToAppear(WebElement findby) { 
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 wait.until(ExpectedConditions.visibilityOf(findby));
}
 public Cartpage goToCartPage() {
	 cartHeader.click();
	 Cartpage cartpage= new Cartpage(driver);
	 return cartpage;
 }
 public void waitForElementToDisappear(WebElement ele) {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.invisibilityOf(ele));
 }
 

}
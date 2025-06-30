package reuse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable {
	WebDriver driver;
	public Reusable(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement Cartclick;
	public void Productsss(By find) {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(find));
	}
	public void InvisiblytyCheckofProduct(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(Element));
		
	}
	public void reusableCartClick() {
		Cartclick.click();
	}

}

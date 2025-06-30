package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import AMIT.TCS.Login_POM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	public Login_POM L;
	@BeforeMethod
	public void login() {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		L = new Login_POM(driver); 
	L.URL();
		
	}

}

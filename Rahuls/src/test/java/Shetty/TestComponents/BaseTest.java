package Shetty.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Shetty.Rahuls.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public LoginPage L;
	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException{
		Properties prop = new Properties();
		FileInputStream f= new FileInputStream("C:\\Users\\AMIT\\eclipse-workspace\\Rahuls\\src\\main\\java\\Shetty\\resources\\GobalData.properties");
		prop.load(f);
		String browserName=prop.getProperty("Browser");
		if(browserName.equalsIgnoreCase("chrome")) {
		
		 WebDriverManager.chromedriver().setup();
		    driver= new ChromeDriver();
		    
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//code
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//code
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    return driver;
	}
	public String getScreenshot(WebDriver driver, String testCaseName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File f= new File(System.getProperty("user.dir") + "//reports//" +testCaseName+ ".png");
		FileUtils.copyFile(source, f);
		return System.getProperty("user.dir") + "//reports//" +testCaseName+ ".png";
		
		

	}
	@BeforeMethod
	public LoginPage launch() throws IOException {
		driver =initializeDriver();
		L= new LoginPage(driver);	
	    L.URL();
	    return L;
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

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
public class ErrorValidation extends BaseTest {
@Test
public void submitOrder1() throws IOException {
	
	
    
   /*Catalog catalog=*/ L.loginApp("a@gmail.com", "Automation@8");
//Catalog catalog=  we dont need it now after developing framework step by step so commenting
   Assert.assertEquals("Incorrect email or passwo", L.getErrorMessage());
    
}
		
	}
	

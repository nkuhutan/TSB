package NKuhutan.TSB;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebConnector
{
	public WebDriver driver;	
	public WebConnector() {		
	}
	
	public void initChromeDriver() {
		System.setProperty("webdriver.chrome.driver","./src/test/lib/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(chromeOptions);
		
	}
	
	public void closeDriver() {
		driver.close();
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}	
	
	
	
}

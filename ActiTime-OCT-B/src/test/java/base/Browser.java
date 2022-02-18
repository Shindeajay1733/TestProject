package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser 
{
	
	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver launchFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Downloads\\geckodriver-v0.30.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	public static WebDriver launchOperaBrowser() {
		System.setProperty("webdriver.opera.driver", "C:\\Users\\Administrator\\Downloads\\operadriver_win32\\operadriver_win32\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver;
	}
	
	

}

package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationHeader;
import pom.LoginPage;
import utils.Utility;

public class TestClass2 extends Browser
{
		private WebDriver driver;
		private ApplicationHeader applicationHeader;
		private LoginPage loginPage;
		private SoftAssert softAssert;
		private int testID;
		static ExtentTest test;
		static ExtentHtmlReporter reporter;
		
		@BeforeTest
		@Parameters("browser")
		public void launchBrowser(String browser) {
			reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
			ExtentReports extend = new ExtentReports();
			extend.attachReporter(reporter);
			System.out.println(browser);
			
			if(browser.equalsIgnoreCase("Chrome")) {
				driver = launchChromeBrowser();
			}
			if(browser.equalsIgnoreCase("Firefox")) {
				driver = launchFirefoxBrowser();
			}
			if(browser.equalsIgnoreCase("Opera")) {
				driver = launchOperaBrowser();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		@BeforeClass
		public void createPOMObjects() {
			loginPage = new LoginPage(driver);
			applicationHeader = new ApplicationHeader(driver);	
		}
		@BeforeMethod
		public void loginToApplication() throws EncryptedDocumentException, IOException {
			driver.get("http://localhost/login.do");
			String useName = Utility.getDataFromExcel("Ajay", 0, 0);
			loginPage.sendUserName(useName);
			String password = Utility.getDataFromExcel("Ajay", 0,1);
			loginPage.sendPassword(password);
			loginPage.selectKeepMeLogin();
			loginPage.clickOnLogin();
		}
		@Test
		public void toVarifyTaskButton() throws InterruptedException {
			testID = 101;
			softAssert =  new SoftAssert();
			applicationHeader.clickTaskPage();
			Thread.sleep(2000);
			String url = driver.getCurrentUrl();
			String title = driver.getTitle();
		
			softAssert.assertEquals(url, "http://localhost/tasks/otasklist.do", "url is not equal");
			softAssert.assertNotEquals(url, "http://localhost/tasks/otasklist.dos", "url is equal");
			boolean result = url.equals("http://localhost/tasks/otasklist.do");
			softAssert.assertTrue(result, "url is not equal");
			boolean value = title.equals("actiTIME - Open Tasks ");
			softAssert.assertFalse(value, "title is equal");
			softAssert.assertAll();
		}
		@Test
		public void varifyUserTab() throws InterruptedException {
			testID = 102;
			applicationHeader.clickUsersPage();
			Thread.sleep(2000);
			String url = driver.getCurrentUrl();
			String title = driver.getTitle();
			
			Assert.assertEquals(url, "http://localhost/administration/userlist.do", "URL of user is not  matched");
			Assert.assertNotEquals(title, "actiTIME - User List ", "title is equal");
			boolean result = url.equals("http://localhost/administration/userlist.do");
			Assert.assertTrue(result, " not Good");
			boolean value = title.equals("actiTIME - User List ");
			Assert.assertFalse(value, " not Good");
		}
		@AfterMethod
		public void logoutFromApplication(ITestResult result) throws IOException {
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utility.getScreenshot(driver, testID);
			}
			applicationHeader.clickToLogoutActiTime();
		}
		@AfterClass
		public void clearPOMObject() {
			
			loginPage = null;
			applicationHeader = null;
		}
		@AfterTest
		public void closedBrowser() {
			driver.quit();
			driver = null;
			System.gc(); //To Delete the Object
		}	
}


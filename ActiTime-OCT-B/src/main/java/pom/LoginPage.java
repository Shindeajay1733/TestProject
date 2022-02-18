package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	private WebElement keepMeLoggedInCheckBox;
	
	@FindBy (xpath = "//a[@id='loginButton']/div")
	private WebElement login;
	
	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public  void sendUserName(String userID)
	{
		
		userName.sendKeys(userID);
	}
	
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void selectKeepMeLogin()
	{
		keepMeLoggedInCheckBox.click();
	}
	public String getTextOfLoginButton()
	{
		String text = login.getText();
		return text;
	}
	
	public void clickOnLogin()
	{
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
	}
	
	
	public void loginToApplication()
	{
		userName.sendKeys("admin");
		password.sendKeys("manager");
		keepMeLoggedInCheckBox.click();
		login.click();		
	}
	
	
	
}

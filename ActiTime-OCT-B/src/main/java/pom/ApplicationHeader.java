package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeader {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions ;
	@FindBy (xpath = "//a[@class='content tt_selected selected']")
	private WebElement timeTrackPage;
	
	@FindBy (xpath = "//a[@class='content tasks']")
	private WebElement taskPage;
	
	@FindBy (xpath = "//a[@class='content reports']")
	private WebElement reportsPage;
	
	@FindBy (xpath = "//a[@class='content users']")
	private WebElement usersPage;
	
	@FindBy (xpath = "//a[@class='content calendar']")
	private WebElement workSchedulePage;
	
	@FindBy (xpath = "//a[@class='logout']")
	private WebElement actiTimeLogout;
	
	public ApplicationHeader(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver =driver;
		actions = new Actions(driver);
	}
	
	public void clickTimeTrackPage()
	{
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(timeTrackPage));
		actions.moveToElement(timeTrackPage).click().build().perform();
		//timeTrackPage.click();
	}
	
	public void clickTaskPage()
	{
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(taskPage));
		actions.moveToElement(taskPage).click().build().perform();
		//taskPage.click();
	}
	public void clickReportsPage()
	{
		wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(reportsPage));
		reportsPage.click();
	}
	public void clickUsersPage()
	{
		usersPage.click();
	}
	public void clickWorkSchedulePage()
	{
		workSchedulePage.click();
	}
	public void clickToLogoutActiTime()
	{
		actiTimeLogout.click();
	}
	

}

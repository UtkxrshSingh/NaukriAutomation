package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	Actions keyMouse;
	
	@FindBy(id="login_Layer")
	WebElement loginPageButton;
	
	@FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
	WebElement usernameField;
	
	@FindBy(xpath = "//input[@placeholder='Enter your password']" )
	WebElement passwordField;
	
	@FindBy(xpath="//button[@class='btn-primary loginButton']")
	WebElement loginButton;
	
	@FindBy (xpath ="//input[@class='suggestor-input ']")
	WebElement keywordLocator;
	
	@FindBy (xpath="//input[@placeholder='Enter location']")
	WebElement locationLocator;
	
	@FindBy (xpath = "//div[@class='qsbSubmit']")
	WebElement searchButton;
	
	@FindBy (xpath="//a[@href='/nlogin/forgotpassword' and 'Forgot password?'] ")
	WebElement forgotPasswordButton;
	
	@FindBy (id="usernameField")
	WebElement forgotPasswordUsername;
	
	@FindBy (xpath = "//span[@class='erLbl green-text fs11 success-text']")
	WebElement forgotPassMsg;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openLogin() {
		loginPageButton.click();
	}
	public void enterUsername(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	public boolean verifyHomepage(String Keyword) {
		String loginTitle=driver.getTitle();
		String expLoginTitle = Keyword;
		
		if(loginTitle.contains(expLoginTitle) && (driver.findElement(By.xpath("//div[@class='keywordSugg']")).isDisplayed()))
		{
			return true;
		}
		return false;	
	}
	public boolean verifyLogin() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("homepage"));
		String ActHPTitle = driver.getTitle();
		String ExpHPTitle = "Mynaukri";
		
		if(ActHPTitle.contains(ExpHPTitle))
		{
			return true;
		}
		return false;
			
		
	
	}
	public boolean verifyInvalidLogin() {
		if (driver.findElement(By.xpath("//div[@class=\"server-err\"]")).isDisplayed()){
			return true;
		}
		return false;
	}
	
	public void keywordSearch(String Keyword) {
		keyMouse = new Actions(driver);
		keywordLocator.sendKeys(Keyword);
		keyMouse.sendKeys(Keys.ENTER).perform();
		
	}
	public boolean checkSimpleSearch(String Keyword) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']")));
		String SearchTitleActual=driver.getTitle();
		String SearchTitleExp="Java Developer";
		if ((SearchTitleActual.contains(SearchTitleExp)) && (driver.findElement(By.xpath("//div[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']")).isDisplayed())){
			return true;
		}
		return false;
	}
	public void Search2(String Keyword,String Location) {
		keywordLocator.clear();
		keywordLocator.sendKeys(Keyword);
		locationLocator.clear();
		locationLocator.sendKeys("Bengaluru");
		searchButton.click();	
	}
	public boolean checkSearch2() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']")));
		String searchedLocation = driver.findElement(By.xpath("(//span[@class='ni-job-tuple-icon ni-job-tuple-icon-srp-location loc']//span)[1]")).getText();
		if (searchedLocation.contains("Bengaluru")) {
			return true;
		}
		return false;
		
	}
	public boolean verifyLogOut() {
		if ((loginPageButton.isDisplayed())){
			return true;
		}
		return false;
	}
	public void forgotPassword(){
		String firstWindow = driver.getWindowHandle();
		loginPageButton.click();
		forgotPasswordButton.click();
		Set<String> windows = driver.getWindowHandles();
		for(String window :windows) {
			if (!window.equals(firstWindow)) {
				driver.switchTo().window(window);
			}
		}
		forgotPasswordUsername.sendKeys("utkarsh__singh@outlook.com");
		keyMouse= new Actions(driver);
		keyMouse.sendKeys(Keys.ENTER).build().perform();	
	}
	
	public boolean verifyForgotPassword() {
		if (forgotPassMsg.isDisplayed()) {
			return true;
		}
		return false;
	}
		
}

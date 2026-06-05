package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (xpath="//div[@class='nI-gNb-sb__main']")
	WebElement homeSearchLocator;
	
	@FindBy (xpath="//input[@placeholder='Enter keyword / designation / companies']")
	WebElement designationSearchLocator;
	
	@FindBy (xpath = "//button[@class='nI-gNb-sb__icon-wrapper']")
	WebElement HomePageSearch;
	
	@FindBy (xpath ="//div[@class='nI-gNb-drawer__icon']")
	WebElement ProfileIconButton;
	
	@FindBy (xpath="//a[@title=\"Logout\"]")
	WebElement LogoutButton;
	
	@FindBy(className="nI-gNb-img-wrapper")
	WebElement openProfileLocator;
	
	//@FindBy(xpath ="//a[@href='javascript:;' and text() ='Upload']")
	//@FindBy(xpath ="//div[@class='dummyUploadNew'] //span [@class='dummyUploadNewCTA' and text()= 'Upload resume']")
	@FindBy (xpath="//div[@class='uploadContainer'] //input[@type='file']")
	WebElement ResumeUploadButton;
	
	@FindBy (className="dummyUploadNew")
	WebElement ResumeUploadLocation;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public void Search(String Job) {
		homeSearchLocator.click();
		designationSearchLocator.clear();
		designationSearchLocator.sendKeys(Job);
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='nI-gNb-sb__full-view nI-gNb-sb__full-view--expand']"))));
		HomePageSearch.click();
	}
	
	public void openProfileMenu() {
		ProfileIconButton.click();
	}
	
	public void clickLogout() {
		LogoutButton.click();
	}
	
	public void uploadResume(){
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ProfileIconButton.click();
		wait.until(ExpectedConditions.visibilityOf(openProfileLocator));
		openProfileLocator.click();
		js.executeScript("window.scrollBy(0,500);");
		wait.until(ExpectedConditions.visibilityOf(ResumeUploadLocation));
		ResumeUploadButton.sendKeys("C:\\Users\\utkar\\Downloads\\AutomationTest.pdf");
	}
	
	public void verifyResumeUpload() {
		
	}
}

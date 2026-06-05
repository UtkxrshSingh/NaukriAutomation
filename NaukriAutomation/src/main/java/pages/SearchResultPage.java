package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
		WebDriver driver;
		Actions keyMouse;
		
		@FindBy (xpath="//div [@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']//a")
		WebElement firstResultLocator;
		
		@FindBy(xpath="//span[@class=\"ni-job-tuple-icon ni-job-tuple-icon-srpSaveUnfilled un-saved save-job-tag\"]")
		WebElement JobSaveLocator;
		
		@FindBy(xpath="//a[@class='nI-gNb-menuItems__anchorDropdown']")
		WebElement JobsButtonLocator;
		
		@FindBy (xpath="//a[@href='/mnjuser/savedjobs']")
		WebElement savedJobsListLocator;
		
		public SearchResultPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public String[] openFirstResult() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div [@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']//a"))));
			String firstWindow = driver.getWindowHandle();
			String expSearchTitle = driver.findElement(By.xpath("//a [@class='title ']")).getText();
			String firstResultImage = driver.findElement(By.xpath("//div[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']//img")).getAttribute("src");
			firstResultLocator.click();
			String[] arr= {firstWindow,expSearchTitle,firstResultImage};
			return arr;
			
		}
		public boolean verifyFirstResult(String firstWindow,String expJobTitle,String firstResultImage) {
			Set<String> windowHandles = driver.getWindowHandles();
			for (String window :windowHandles) {
				if (!window.equals(firstWindow)) {
					driver.switchTo().window(window);
				}
			}
			String actJobTitle = driver.getTitle();
			String companyImage= driver.findElement(By.xpath("//section[@class='styles_job-header-container___0wLZ'] //img")).getAttribute("src");
			if ((actJobTitle.contains(expJobTitle)) && (companyImage.equals(firstResultImage))){
				return true;
			}
			return false;
		}
		
		public String firstJobSave() {
			String firstJobTitle = driver.findElement(By.xpath("//div[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']//a")).getAttribute("title");
			JobSaveLocator.click();
			return firstJobTitle;
		}
		
		public void savedJobs() {
			keyMouse = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(JobsButtonLocator));
			keyMouse.moveToElement(JobsButtonLocator);
			keyMouse.moveToElement(savedJobsListLocator).click().perform();
			
		}

		public boolean verifySavedJob(String expJobTitle) {
			String actJobTitle = driver.findElement(By.xpath("//div[@class='header-container']//div//div")).getAttribute("title");
			if (actJobTitle.contains(expJobTitle)) {
				return true;
			}
			return false;
			
		}
}

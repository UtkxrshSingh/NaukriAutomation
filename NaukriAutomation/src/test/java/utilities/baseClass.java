package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class baseClass {
		public WebDriver driver;
		
		@BeforeMethod
		public void setup() {
			driver=new ChromeDriver();
			driver.get("https://www.naukri.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			
		}
		
		@AfterMethod
		public void teardown() {
			driver.quit();
		}
	
}

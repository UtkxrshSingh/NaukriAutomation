package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultPage;
import utilities.baseClass;

public class NaukriTest extends baseClass {
	File src1 = new File("C:\\Users\\utkar\\eclipse-workspace\\NaukriAutomation\\testData\\idPass.properties");
		
	
	@Test (priority=10,description="Open Home Page")
	public void verifyPage() {
		LoginPage loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.verifyHomepage("Naukri"),"Test Case 1 Failed");
	}
	
	@Test(priority=20,description="Valid Login")
	public void login() throws IOException {
		FileInputStream fis1 = new FileInputStream(src1);
		Properties pro1 =new Properties();
		pro1.load(fis1);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.openLogin();
		loginpage.enterUsername(pro1.getProperty("username"));
		loginpage.enterPassword(pro1.getProperty("password"));
		loginpage.clickLogin();	
		loginpage.verifyLogin();
		Assert.assertTrue(loginpage.verifyLogin(), "TestCase 2 Failed");
	}
	
	@Test (priority=30,description="Invalid Login")
	public void invalidLogin() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.openLogin();
		loginpage.enterUsername("utkarsh");
		loginpage.enterPassword("12345");
		loginpage.clickLogin();	
		Assert.assertTrue(loginpage.verifyInvalidLogin(), "TestCase 3 Failed");
	}
	
	@Test (priority=40,description="Basic job search (keyword only)")
	public void SimpleSearch() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.keywordSearch("Java Developer");
		Assert.assertTrue(loginpage.checkSimpleSearch("Java Developer"),"TestCase 4 Failed");
	}
	
	@Test (priority=50,groups="smoke",description="Basic job search (keyword + location)")
	public void Search2() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Search2("Java","Bengaluru");
		Assert.assertTrue(loginpage.checkSearch2(),"TestCase 5 Failed");
	}
	
	@Test (priority=60,description="Open a job detail")
	public void JobDetail() {
		LoginPage loginpage = new LoginPage(driver);
		SearchResultPage searchpage = new SearchResultPage(driver);
		loginpage.Search2("Java","Bengaluru");
		String[] firstWindowProp =searchpage.openFirstResult();
		String firstWindowHandle =firstWindowProp[0].toString();
		String expJobTitle =firstWindowProp[1].toString();
		String firstJobImage=firstWindowProp[2];
		Assert.assertTrue(searchpage.verifyFirstResult(firstWindowHandle,expJobTitle,firstJobImage),"TestCase 6 Failed");
	}
	@Test (priority =70,description="Save (bookmark) a job — logged in")
	public void jobBookmark() throws IOException {
		FileInputStream fis1 = new FileInputStream(src1);
		Properties pro1 =new Properties();
		pro1.load(fis1);
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage =new HomePage(driver);
		SearchResultPage searchpage =new SearchResultPage(driver);
		loginpage.openLogin();
		loginpage.enterUsername(pro1.getProperty("username"));
		loginpage.enterPassword(pro1.getProperty("password"));
		loginpage.clickLogin();
		homepage.Search("Java");
		String firstSavedTitle = searchpage.firstJobSave();
		searchpage.savedJobs();
		Assert.assertTrue(searchpage.verifySavedJob(firstSavedTitle), "TestCase 7 Failed");
	}
	
	@Test (priority=80,description="Logout")
	public void Logout() throws IOException {
		FileInputStream fis1 = new FileInputStream(src1);
		Properties pro1 =new Properties();
		pro1.load(fis1);
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage =new HomePage(driver);
		loginpage.openLogin();
		loginpage.enterUsername(pro1.getProperty("username"));
		loginpage.enterPassword(pro1.getProperty("password"));
		loginpage.clickLogin();
		homepage.openProfileMenu();
		homepage.clickLogout();
		Assert.assertTrue(loginpage.verifyLogOut(), "TestCase 8 failed");
	}
	
	@Test (priority=90,description="Upload resume (simple)")
	public void uploadResume() throws IOException {
		FileInputStream fis1 = new FileInputStream(src1);
		Properties pro1 =new Properties();
		pro1.load(fis1);
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage =new HomePage(driver);
		loginpage.openLogin();
		loginpage.enterUsername(pro1.getProperty("username"));
		loginpage.enterPassword(pro1.getProperty("password"));
		loginpage.clickLogin();
		homepage.uploadResume();
	}
	
	@Test (priority=100,description="Forgot Password (UI flow)")
	public void forgetPassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.forgotPassword();
		Assert.assertTrue(loginpage.verifyForgotPassword(),"TestCase 10 failed");
	}
	
	
	
}
package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resourses.base;

public class HomePageTest extends base{
	
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(HomePageTest.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		
		LandingPage l=new LandingPage(driver);
		log.info("Navigate to the landingpage");
		LoginPage lp=l.getLogin();
		
	//	LoginPage lp=new LoginPage(driver);
		log.info("Navigate to the LoginPage");
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		System.out.println(text);
		log.info(text);
		log.info("Username and password entered successfully");
		lp.getLogin().click();
		
		ForgotPasswordPage fp=lp.forgotPassword();
		fp.getemailid().sendKeys("forgotpassword@gmail.com");
		fp.getSendmeInstruction().click();
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data=new Object[2][3];
		
		// oth row
		data[0][0]="nonrestricteduser@gmail.com";
		data[0][1]="122345";
		data[0][2]="non restricted user";
		
		// 1st row
		data[1][0]="restricteduser@gmail.com";
		data[1][1]="6547373";
		data[1][2]="restricted user";
		
		return data;
	}
	

	
	@AfterTest
	public void tearDown()
	{
		driver.close();;
	}

}

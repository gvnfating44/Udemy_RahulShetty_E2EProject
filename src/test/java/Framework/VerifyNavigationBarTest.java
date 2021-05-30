package Framework;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resourses.base;

public class VerifyNavigationBarTest extends base{
	
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(VerifyNavigationBarTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void baseNavigationBar() throws IOException
	{
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		System.out.println("navigation bar verified Successfully");
		log.info("Navigation Bar is display");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}

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

public class VerifyTitleTest extends base {
	
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(VerifyTitleTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to HomePage");
	}
	
	@Test
	public void VerifyFestureCourseText() throws IOException
	{	
		LandingPage l= new LandingPage(driver);
		String actualvalue=l.getTitle().getText();
		String expectedvalue="FEATURED COURSES123";
		Assert.assertEquals(actualvalue, expectedvalue);
		log.info("Successfully validate text message");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}

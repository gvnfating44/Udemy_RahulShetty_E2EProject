package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	////a[contains(@href,'sign_in')]
	////span[contains(text(),'Login')]
	@FindBy(xpath="//a[contains(@href,'sign_in')]")
	WebElement signin;
	
	@FindBy(xpath="//div[@class='text-center']/h2")
	WebElement title;
	
	@FindBy(xpath="//nav[@class='navbar-collapse collapse']")
	WebElement navigationbar;
	
	
	public LoginPage getLogin()
	{
		 signin.click();
		 LoginPage lp=new LoginPage(driver);
		 return lp;
	}
	
	public WebElement getTitle()
	{
		return title;
	}
	
	public WebElement getNavigationBar()
	{
		return navigationbar;
	}

}

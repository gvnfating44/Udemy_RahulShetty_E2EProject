package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//a[@class='link-below-button']")
	WebElement forgotpassword;
	
	public WebElement getEmail()
	{
		return email;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getLogin()
	{
		return login;
	}
	
	public ForgotPasswordPage forgotPassword()
	{
		forgotpassword.click();
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		return fp;
	}

}

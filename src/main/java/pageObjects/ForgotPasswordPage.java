package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	public WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	WebElement emailid;
	
	@FindBy(xpath="//input[@name='commit']")
	WebElement sendmeinstruction;

	public WebElement getemailid()
	{
		return emailid;
	}
	
	public WebElement getSendmeInstruction()
	{
		return sendmeinstruction;
	}

}

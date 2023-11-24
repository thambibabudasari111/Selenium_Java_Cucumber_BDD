package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="Email")
	WebElement email;
	

	@FindBy(id="Password")
	WebElement password;
	

	@FindBy(xpath="//*[@type='submit' and text()='Log in']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	
	public void setUserName(String username)
	{
		email.clear();
		email.sendKeys(username);
	}
	
	public void setPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void clickLogut()
	{
		logout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

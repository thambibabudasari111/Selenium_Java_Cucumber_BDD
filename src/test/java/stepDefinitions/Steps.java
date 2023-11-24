package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Steps {

	public WebDriver driver;
	public LoginPage loginPage;
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
	   
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage=new LoginPage(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    
		driver.get(url);
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    loginPage.setUserName(email);
	    loginPage.setPassword(password);
	}

	@When("Click on login")
	public void click_on_login() {
	    
		loginPage.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	    
		if(driver.getPageSource().contains("Login was unsuccessful."))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertEquals(title, driver.getTitle());
		}
		
	}

	@When("User clicks on logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
		Thread.sleep(3000);
		loginPage.clickLogut();
		Thread.sleep(3000);
	}

	@Then("Close browser")
	public void close_browser() {
	   
		driver.quit();
	}

}

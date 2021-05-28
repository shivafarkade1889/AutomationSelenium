package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	private By email = By.xpath("//input[@id='user_email']");

	private By pass = By.xpath("//input[@id='user_password']");
	
	private By loginB = By.xpath("//input[@name='commit']");
	
	private By forgotPass = By.xpath("//a[normalize-space()='Forgot Password?']");

	public WebElement emailTextBox() {
		return driver.findElement(email);
	}
	
	public WebElement passwordTextBox() {
		return driver.findElement(pass);
	}
	
	public WebElement loginButton() {
		return driver.findElement(loginB);
	}
	
	
	public  ForgotPage forgotPasswordLink() {
		driver.findElement(forgotPass).click();
		return new ForgotPage(driver);
	}	
		
	public   WebElement forgotPasswordLink1() {
		return driver.findElement(forgotPass);
			 
	}
}

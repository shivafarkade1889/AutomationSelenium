package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesForceLandingPage {
public WebDriver driver;
	
	public SalesForceLandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By userName = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//input[@id='Login']");
	private By errorMSG = By.xpath("//div[@id='error']");
	
	public  WebElement userNameEditBox() {
		return driver.findElement(userName);
	}
	
	public  WebElement passwordEditBox() {
		return driver.findElement(password);
	}
	
	public  WebElement loginButtonIcon() {
		return driver.findElement(loginButton);
	}
	
	public  WebElement errorMessage() {
		return driver.findElement(errorMSG);
	}
}

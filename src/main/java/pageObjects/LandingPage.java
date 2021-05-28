package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

public WebDriver driver;

public LandingPage(WebDriver driver) {
	this.driver=driver;
}


private By login = By.xpath("//a[normalize-space()='Login']");

private By title = By.xpath("//div[@class='col-md-6 text-left']//h2");

private By icon = By.xpath("//div[@class='nav-outer clearfix']//a[normalize-space()='Consulting']");

public  LoginPage loginButton() {
	 driver.findElement(login).click();
	 return new LoginPage(driver);
}

public WebElement getTitleofCurrentPage() {
	return driver.findElement(title);
}
	
public WebElement getMenuIcon() {
	return driver.findElement(icon);
}

public   WebElement loginButton1() {
	return driver.findElement(login);
	  
}

}
